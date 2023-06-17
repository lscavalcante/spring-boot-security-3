package com.lscavalcante.security.services;

import com.lscavalcante.security.config.JwtService;
import com.lscavalcante.security.dto.RegisterDTO;
import com.lscavalcante.security.dto.SignInDTO;
import com.lscavalcante.security.dto.TokenDTO;
import com.lscavalcante.security.exception.NotFoundException;
import com.lscavalcante.security.exception.RecordNotFoundException;
import com.lscavalcante.security.model.Role;
import com.lscavalcante.security.model.User;
import com.lscavalcante.security.repository.RoleRepository;
import com.lscavalcante.security.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, JwtService jwtService, AuthenticationManager authenticationManager, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public TokenDTO login(SignInDTO dto) {
        try {
            var username = dto.getEmail();
            var password = dto.getPassword();

            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>()));

            User user = userRepository.findByEmail(username).orElseThrow(() -> new RecordNotFoundException("user not found"));

            return jwtService.createJWT(user);
        } catch (Exception e) {
            throw new BadCredentialsException(e.getMessage(), e);
        }
    }


    public String register(RegisterDTO dto) {
        try {

            if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
                throw new RuntimeException("User already exists");
            }

            User user = new User();
            user.setEmail(dto.getEmail());
            user.setFirstname(dto.getFirstName());
            user.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
            user.setRoles(roleRepository.findAll());
            userRepository.save(user);

            return "User register with success";
        } catch (Exception e) {
            throw e;
        }
    }


}
