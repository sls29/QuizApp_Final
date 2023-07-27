package com.QuizApp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login-api")
public class LoginApiServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp )
            throws ServletException, IOException {

        String email = req.getParameter("eemail");
        String password = req.getParameter("ppassword");

    }
}
