<%@ page import="com.QuizApp.model.User, com.QuizApp.repository.JpaUserRepository" %>

<%
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String email = request.getParameter("email");
      String passwordHash = request.getParameter("password");


      User user = new User(firstName, lastName, email, passwordHash, null, null);

      JpaUserRepository userRepo = new JpaUserRepository();

      userRepo.userRegistration(user);

%>

  <meta http-equiv="Refresh" content="0; url='/QuizApp_Final" />