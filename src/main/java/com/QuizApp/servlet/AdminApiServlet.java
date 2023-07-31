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

        try {
            userService.deleteUser(email);
        } catch (Exception e) {
            out.println(e.getMessage());
        }
        String val1="User deleted.";
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Servlet Mesg</title>");
        out.println("</head>");
        out.println("<body onLoad=\"showResult();\">");
        out.println("<script>");
        out.println("function showResult(){");
        out.println("alert(\""+val1+"\")");
        out.println("}");
        out.println("</script>");
        out.println("</body>");
        out.println("</html>");
//        out.println("User deleted");
//        resp.getOutputStream().println("<h1 style='text-align:center'</h1><a href='index.jsp'>User deleted!</a>");
        RequestDispatcher rs = req.getRequestDispatcher("admin.jsp");
        rs.forward(req, resp);
    }

}
