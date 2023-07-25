<%@ page import="com.QuizApp.model.User, com.QuizApp.repository.JpaUserRepository" %>


<%
  String name = request.getParameter("email");
  String email = request.getParameter("password");

  User user = new User(email, password);

  JpaUserRepository userRepo = new JpaUserRepository();

  UserRepo.userLogin(user);

%>