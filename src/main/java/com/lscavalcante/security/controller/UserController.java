package com.lscavalcante.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    public String get() {
        return "";
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
