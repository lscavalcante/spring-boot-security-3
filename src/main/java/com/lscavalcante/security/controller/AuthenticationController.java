package com.lscavalcante.security.controller;

import com.lscavalcante.security.dto.SignInDTO;
import com.lscavalcante.security.dto.TokenDTO;
import com.lscavalcante.security.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    final private UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String get() {
        return "";
    }

    @PostMapping()
    public ResponseEntity<TokenDTO> post(@RequestBody @Validated SignInDTO dto) {
        var data = userService.signIn(dto);

        return ResponseEntity.ok(data);
    }
}
