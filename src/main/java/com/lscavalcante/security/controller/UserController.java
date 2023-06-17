package com.lscavalcante.security.controller;

import com.lscavalcante.security.dto.UserDTO;
import com.lscavalcante.security.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.listAll());
    }

    @PostMapping()
    public String post() {

        return "authenticated";
    }

    @PostMapping("staff")
    public String postStaff() {

        return "only staff access here";
    }

    @PostMapping("admin")
    public String postAdmin() {

        return "only admin access here";
    }

    @PostMapping("permission")
    public String postPermission() {

        return "only users with permission admin:create access here";
    }

}
