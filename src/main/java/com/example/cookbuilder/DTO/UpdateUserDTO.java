package com.example.cookbuilder.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor @Data
public class UpdateUserDTO {
    @Email(message = "Email must be in an email format")
    @NotEmpty(message = "currentEmail cannot be null")
    private String currentEmail;
    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @Column(unique = true)
    @Email(message = "Email must be in an email format")
    @NotEmpty(message = "email cannot be empty")
    private String email;
    @NotEmpty(message = "password cannot be empty")
    private String password;

}
