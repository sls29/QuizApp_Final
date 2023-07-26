package com.QuizApp.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateUserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private String registeredAt;
    private String lastLogin;

}