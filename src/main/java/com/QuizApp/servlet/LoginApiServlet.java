package com.QuizApp.servlet;

import com.QuizApp.model.User;
import com.QuizApp.repository.JpaUserRepository;
import com.QuizApp.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.Date;

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

        String email = req.getParameter("eemail");
        String password = req.getParameter("ppassword");

        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Cache-Control","no-store");

        if(userService.validateUserLogin(email, password)) {

            HttpSession session = req.getSession(true);
            session.setAttribute("email", email);

            Cookie loginCookie = new Cookie("email", email);


            loginCookie.setMaxAge(15*60);
            resp.addCookie(loginCookie);
            resp.sendRedirect("welcome.jsp");


//            String val1="Logged in successfully.";
//            String val2="SessionID: "+session.getId() ;
//            String val3="Creation time: " + new Date(session.getCreationTime());

//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Login Servlet Msg</title>");
//            out.println("</head>");
//            out.println("<body onLoad=\"showResult():\">");
//            out.println("<script>");
//            out.println("function showResult(){");
//            out.println("alert(\""+val1+"\");");
//            out.println("}");
//            out.println("</script>");
//            out.println("</body>");
//            out.println("</html>");

//            out.println("Logged in successfully");
//            out.println("SessionID: "+session.getId());
//            out.println("Creation time: " + new Date(session.getCreationTime()));
//            out.println("<a href='DisplaySessionValueServlet'>" + "Click here</a>");
//            out.println("<br/>");
//            out.println("<h1 style='text-align:center'</h1><a href='logout-api'>Logout</a>");
//            RequestDispatcher rs = req.getRequestDispatcher("welcome.jsp");
//            rs.forward(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
//            PrintWriter out= resp.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(req, resp);
        }

//            String val1="Incorrect Email or Password";
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Login Servlet Mesg</title>");
//            out.println("</head>");
//            out.println("<body onLoad=\"showResult();\">");
//            out.println("<script>");
//            out.println("function showResult(){");
//            out.println("alert(\""+val1+"\")");
//            out.println("}");
//            out.println("</script>");
//            out.println("</body>");
//            out.println("</html>");
////            out.println("Incorrect Email or Password");
//            RequestDispatcher rs = req.getRequestDispatcher("index.jsp");
//            rs.include(req, resp);

        }
    }

