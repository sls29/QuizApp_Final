package com.QuizApp.service;

public class PasswordService {

    public static boolean validatePassword(String password, String passwordCk) {
        return password.equals(passwordCk);
    }
}


