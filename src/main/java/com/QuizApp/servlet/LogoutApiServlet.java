package com.QuizApp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/logout-api")
public class LogoutApiServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public LogoutApiServlet(){
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");
        System.out.println("Session before invalidate: " + req.getSession(false));
        req.getSession(false).invalidate();
        System.out.println("Session after invalidate: " + req.getSession(false));
        out.println("You are successfully logged out.");
        out.println("<br/>");
        out.println("<h1 style='text-align:center'</h1><a href='index.jsp'>Go to Start Page</a>");

        out.close();
    }
}
