<%@ page import="com.QuizApp.User, com.QuizApp.JpaUserRepository" %>

<%
      JpaUserRepository repository = new JpaUserRepository();

      String firstName = req.getParameter("add_firstName");
      String lastName = req.getParameter("add_lastName");
      String email = req.getParameter("add_email");
      String password = req.getParameter("add_password");
      String passwordCk = req.getParameter("add_password2");

      User user = new User(firstName, lastName, email, passwordHash, registeredAt, null);

      repository.userRegistration(user);

%>

  <meta http-equiv="Refresh" content="0; url='/QuizApp" />