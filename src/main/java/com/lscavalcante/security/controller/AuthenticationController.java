package com.lscavalcante.security.controller;

import com.lscavalcante.security.dto.RegisterDTO;
import com.lscavalcante.security.dto.SignInDTO;
import com.lscavalcante.security.dto.TokenDTO;
import com.lscavalcante.security.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    final private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity<TokenDTO> login(@RequestBody @Validated SignInDTO dto) {
        var data = userService.login(dto);

        return ResponseEntity.ok(data);
    }

    @PostMapping("register")
    public ResponseEntity<Map<String, String>> register(@RequestBody @Validated RegisterDTO dto) {
        String data = userService.register(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("message", data));
    }

}
