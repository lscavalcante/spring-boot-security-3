package com.lscavalcante.security.dto;

public class UserDTO {
    private Integer id;
    private String email;
    private String firstName;


    public UserDTO(Integer id, String email, String firstName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
    }

    public UserDTO() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
