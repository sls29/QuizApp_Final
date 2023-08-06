package com.QuizApp.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordServiceTest {
    @Test
    public void PasswordService() throws Exception {
        boolean ans = true;
        boolean val;
        final String password = "qwe123";
        final String passwordCk = "qwe123";
        val = PasswordService.validatePassword(password, passwordCk);
    Assertions.assertEquals(ans, val);
    }
}