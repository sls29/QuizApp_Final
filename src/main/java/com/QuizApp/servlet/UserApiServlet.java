package com.QuizApp.servlet;

import com.QuizApp.model.User;
import com.QuizApp.model.dto.CreateUserDto;
import com.QuizApp.repository.JpaUserRepository;
import com.QuizApp.service.UserService;
import jakarta.security.enterprise.credential.Password;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.IOException;

import java.io.PrintWriter;


@WebServlet("/user-api")
public class UserApiServlet extends HttpServlet {

    private final UserService userService = new UserService(new JpaUserRepository());
    private final JpaUserRepository userRepository = new JpaUserRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        JpaUserRepository repository = new JpaUserRepository();

    PrintWriter pw = null;

    String firstName = req.getParameter("add_firstName");
    String lastName = req.getParameter("add_lastName");
    String email = req.getParameter("add_email");
    String password = req.getParameter("add_password");
    String passwordCk = req.getParameter("add_password2");

    pw = resp.getWriter();

        String passwordHash = null;
        if (password != passwordCk) {
        pw.println("<h1 style='text-align:center'>"+
                "Password don't match </h1>");

    } else {
        passwordHash = password;
    }

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime registeredAt = LocalDateTime.now();

        CreateUserDto userDto = new CreateUserDto();
        userDto.setFirstName(firstName);
        userDto.setLastName(lastName);
        userDto.setEmail(email);
        userDto.setPasswordHash(password);
        userDto.setRegisteredAt(registeredAt);
        userDto.setLastLogin(null);

        userService.addUser(userDto);

      
    }
}
