package com.QuizApp.servlet;


import com.QuizApp.model.dto.CreateUserDto;
import com.QuizApp.repository.JpaUserRepository;
import com.QuizApp.service.PasswordService;
import com.QuizApp.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.IOException;


@WebServlet("/user-api")
public class UserApiServlet extends HttpServlet {
    private final UserService userService = new UserService(new JpaUserRepository());
    PasswordService passwordService = new PasswordService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    String passwordCk = req.getParameter("password2");



    if(!passwordService.validatePassword(password, passwordCk)) {
        out.println("<font color=red>Password don't match.</font>");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.include(req, resp);

        } else {

        String passwordHash = password;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String registeredAt = dtf.format(now);

        CreateUserDto userDto = new CreateUserDto();
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setPasswordHash(passwordHash);
        userDto.setRegisteredAt(registeredAt);
        userDto.setLastLogin(registeredAt);

        userService.addUser(userDto);
        out.println("<font color=green>User added.</font>");
        out.println("<a href='index.jsp'>Please login!</a>");
//        resp.getOutputStream().println(
//                "<h1 style='text-align:center'</h1><a href='index.jsp'>User added! Please login</a>");
        }
    }
}
