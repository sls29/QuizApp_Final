package com.QuizApp.service;

import jakarta.xml.bind.DatatypeConverter;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordService {

    public static boolean validatePassword(String password, String passwordCk) {
        return password.equals(passwordCk);
    }


    public static String passwordToHash(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return DatatypeConverter.printHexBinary(
                MessageDigest.getInstance("MD5").digest(password.getBytes("UTF-8")));
    }
}