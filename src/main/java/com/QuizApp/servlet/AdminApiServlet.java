package com.QuizApp.servlet;

import com.QuizApp.repository.JpaUserRepository;
import com.QuizApp.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/admin-api")
public class AdminApiServlet extends HttpServlet {
    private final UserService userService = new UserService(new JpaUserRepository());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String email = req.getParameter("email");

        userService.deleteUser(email);
        out.println("<font color=green>User deleted.</font>");
        out.println("<a href='admin.jsp'>Go back to admin page.</a>");

//        RequestDispatcher rs = req.getRequestDispatcher("admin.jsp");
//        rs.forward(req, resp);
    }

}
