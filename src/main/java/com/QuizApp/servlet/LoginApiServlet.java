package com.QuizApp.servlet;

import com.QuizApp.model.User;
import com.QuizApp.repository.JpaUserRepository;
import com.QuizApp.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

//import static jakarta.faces.component.UIWebsocket.PropertyKeys.user;

@WebServlet("/login-api")
public class LoginApiServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    User user = new User();
    public LoginApiServlet(){
        super();
    }
    UserService userService = new UserService(new JpaUserRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp )
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();

        String email = req.getParameter("eemail");
        String password = req.getParameter("ppassword");

        if(userService.validateUserLogin(email, password)) {

            session.setAttribute("email", user);
            RequestDispatcher rs = req.getRequestDispatcher("welcome.jsp");
            rs.forward(req, resp);
        } else {
            out.println("Incorect Email or Password");
            RequestDispatcher rs = req.getRequestDispatcher("index.jsp");
            rs.include(req, resp);
        }

    }
}
