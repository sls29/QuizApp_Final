package com.QuizApp.service;

public class PasswordService {

    public String validatePassword (String password, String passwordCk){
        if (!password.equals(passwordCk)) {
            throw new RuntimeException("Password don't match!");
        }
    return password;
    }
}
