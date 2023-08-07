package com.QuizApp.servlet;

import com.QuizApp.model.User;
import com.QuizApp.repository.JpaUserRepository;
import com.QuizApp.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet("/login-api")
public class LoginApiServlet extends HttpServlet {
    @Serial
//    private static final long serialVersionUID = 1L;
    User user = new User();
    public LoginApiServlet(){
        super();
    }
    UserService userService = new UserService(new JpaUserRepository());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp )
            throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Cache-Control","no-store");

        PrintWriter out = resp.getWriter();

        String email = req.getParameter("eemail");
        String password = req.getParameter("ppassword");

        try {
            if(userService.validateUserLogin(email, password)) {
                if (email.equals("admin@mail.com")){
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String loginTime = dtf.format(now);
                    userService.updateLastLoginDate(email, loginTime);

                    HttpSession session = req.getSession(true);
                    session.setAttribute("email", email);
                    Cookie loginCookie = new Cookie("email", email);
                    loginCookie.setMaxAge(15*60);
                    resp.addCookie(loginCookie);
                    resp.sendRedirect("admin.jsp");
                } else {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    String loginTime = dtf.format(now);
                    userService.updateLastLoginDate(email, loginTime);

                    HttpSession session = req.getSession(true);
                    session.setAttribute("email", email);
                    Cookie loginCookie = new Cookie("email", email);
                    loginCookie.setMaxAge(15 * 60);
                    resp.addCookie(loginCookie);
                    resp.sendRedirect("welcome.jsp");
                }

            } else {
                out.println("<font color=red>Either email or password is wrong.</font>");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                rd.include(req, resp);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

