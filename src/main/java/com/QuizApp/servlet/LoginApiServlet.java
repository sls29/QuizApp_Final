package com.QuizApp.servlet;

import com.QuizApp.repository.JpaUserRepository;
import com.QuizApp.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login-api")
public class LoginApiServlet extends HttpServlet {

    UserService userService = new UserService(new JpaUserRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp )
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String email = req.getParameter("eemail");
        String password = req.getParameter("ppassword");

        if(userService.validateUserLogin(email, password)) {
            RequestDispatcher rs = req.getRequestDispatcher("/welcome");
            rs.forward(req, resp);
        } else {
            out.println("Incorect Email or Password");
            RequestDispatcher rs = req.getRequestDispatcher("index.jsp");
            rs.include(req, resp);
        }

    }
}
