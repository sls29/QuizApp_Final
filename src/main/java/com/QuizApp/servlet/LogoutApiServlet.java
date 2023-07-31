package com.QuizApp.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
//        out.println("Session before invalidate: " + req.getSession(false) + "<br/>");
        req.getSession(false).invalidate();
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Cache-Control","no-store");

        String val1="Session after invalidate: " + req.getSession(false) + "<br/>";
        String val2="You are successfully logged out.";

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Logout Servlet Msg</title>");
        out.println("</head>");
        out.println("<body onLoad='showResult()'>");
        out.println("<script type=\'text/javascript\'>");
        out.println("function showResult(){");
        out.println("alert("+val1+val2+");");
        out.println("}");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");

//        out.println("Session after invalidate: " + req.getSession(false) + "<br/>");
//        out.println("You are successfully logged out.");
//        out.println("<br/>");
//        out.println("<h1 style='text-align:center'</h1><a href='index.jsp'>Go to Start Page</a>");
        RequestDispatcher rs = req.getRequestDispatcher("logout.jsp");
        rs.forward(req, resp);
        out.close();
    }
}
