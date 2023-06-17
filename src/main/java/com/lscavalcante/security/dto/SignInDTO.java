package com.lscavalcante.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SignInDTO {

    @Email
    @NotBlank
    @NotNull
    private String email;

    @Size(min = 3)
    @NotNull
    private String password;

    public SignInDTO() {
    }

    public SignInDTO(String email, @NotNull() String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
