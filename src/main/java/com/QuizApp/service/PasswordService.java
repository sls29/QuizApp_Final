package com.QuizApp.service;

public class PasswordService {

    public boolean validatePassword(String password, String passwordCk) {
        if (!password.equals(passwordCk)) {
            return false;
        }
        return true;
    }
}


