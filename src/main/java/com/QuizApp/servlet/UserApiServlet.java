package com.QuizApp.servlet;


import com.QuizApp.model.dto.CreateUserDto;
import com.QuizApp.repository.JpaUserRepository;
import com.QuizApp.service.PasswordService;
import com.QuizApp.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.IOException;


@WebServlet("/user-api")
public class UserApiServlet extends HttpServlet {
    private final UserService userService = new UserService(new JpaUserRepository());
    PasswordService passwordService = new PasswordService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    String passwordCk = req.getParameter("password2");

    String passwordHash = passwordService.validatePassword(password, passwordCk);

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
    resp.getOutputStream().println("<h1 style='text-align:center'</h1><a href='index.jsp'>User added! Please login</a>");
    }
}
