package com.lscavalcante.security;

import com.lscavalcante.security.config.JwtService;
import com.lscavalcante.security.model.Permission;
import com.lscavalcante.security.model.Role;
import com.lscavalcante.security.model.User;
import com.lscavalcante.security.repository.PermissionRepository;
import com.lscavalcante.security.repository.RoleRepository;
import com.lscavalcante.security.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	UserRepository userRepository;
	RoleRepository roleRepository;
	PermissionRepository permissionRepository;
	JwtService jwtService;

	public SecurityApplication(UserRepository userRepository,
							   PermissionRepository permissionRepository,
							   RoleRepository roleRepository,
							   JwtService jwtService
	) {
		this.userRepository = userRepository;
		this.jwtService = jwtService;
		this.permissionRepository = permissionRepository;
		this.roleRepository = roleRepository;
	}

	@Bean
	void createadConfiguration() {

		Permission permission = new Permission();
		permission.setName("admin:create");
		permissionRepository.save(permission);

		Role role = new Role();
		role.setName("ADMIN");
		role.setPermissions(permissionRepository.findAll());
		roleRepository.save(role);

		User user = new User();
		user.setEmail("admin@admin.com");
		user.setFirstname("admin");
		user.setRoles(roleRepository.findAll());
		user.setPassword(new BCryptPasswordEncoder().encode("admin"));
		userRepository.save(user);


	}

}
