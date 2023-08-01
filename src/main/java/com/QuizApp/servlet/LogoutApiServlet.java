package com.QuizApp.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.Date;

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

        resp.setContentType("text/html; charset=UTF-8");
        req.getSession(false).invalidate();
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Cache-Control","no-store");

//        Cookie loginCookie = new Cookie("email", null);
//        loginCookie.setMaxAge(0);
        Cookie loginCookie = null;
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("email")){
                    loginCookie = cookie;
                    break;
                }
            }
        }
        if(loginCookie != null){
            loginCookie.setMaxAge(0);
            resp.addCookie(loginCookie);
        }
        resp.sendRedirect("logout.jsp");
    }
}
