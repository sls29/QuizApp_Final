package com.QuizApp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class DisplaySessiunValueServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DisplaySessiunValueServlet () {

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws  ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession(false);
        String email = (String)session.getAttribute("email");
        out.println("Email: " + email);
        out.close();
    }
}
