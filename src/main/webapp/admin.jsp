<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.QuizApp.repository.JpaUserRepository" %>
<%@ page import="com.QuizApp.repository.JpaQuestionRepository" %>
<%@ page import="com.QuizApp.repository.JpaQuizRepository" %>
<%@ page import="com.QuizApp.model.User" %>
<%@ page import="java.time.LocalDateTime" %>

<% response.setHeader("Cache-Control", "no-cache, no-store"); %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Quiz Application</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.21.4/dist/bootstrap-table.min.css">
        <style>

            body {
                    background-image: url("https://pilbox.themuse.com/image.jpg?filter=antialias&h=350&opt=1&pos=top-left&prog=1&q=keep&url=https%3A%2F%2Fcms-assets.themuse.com%2Fmedia%2Flead%2Fjob-burnout-quiz-06172022-1251371646-Mohd-Hafiez-Mohd-Razali-EyeEm.jpg&w=700");
                }
            { box-sizing: border-box; }
            .column {
              float: left;
              width: 50%;
              padding: 8px;
              height: 400px;
            }
            .row:after {
              content: "";
              display: table;
              clear: both;
            }
        </style>
    </head>
    <body>
        <title>Administration page</title>
        <div class = "row">
        <h1><%
            String firstName = null;
            Cookie[] cookies = request.getCookies();
                if(cookies != null){
                    for(Cookie cookie : cookies){
                        if(cookie.getName().equals("email")) firstName = cookie.getValue();
                    }
                }
                if(firstName == null) response.sendRedirect("index.jsp");
                %></h1>
        <h1>Administration Page; <%=firstName%> session.</h1>

            <div class="column" style="background-color:#bbb;">
                <h2>User Management</h2>
                <br/>
                <form action="admin-api" method="POST">
                     <div class="form-outline mb-4">
                          <input type="text" name="email" value="Email..." onclick="this.value=''"/><br/>
                     </div>
                     <div class="form-outline mb-4">
                          <input type="submit" value="Delete User" class="btn btn-primary btn-block" />
                     </div>
                </form>
            </div>
            <div class="column" style="background-color:#aaa;">
                <% JpaUserRepository repo3 = new JpaUserRepository(); %>
                <h2>Registered Users - <%=repo3.getNumberOfUsers() %> </h2>
                    <table border="1" class="table table-striped table-hover w-50 p-3">
                    <tr>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Email</th>
                        <th>LastLogin</th>
                        <th>RegisteredAt</th>
                    </tr>
                    <%
                        JpaUserRepository repository = new JpaUserRepository();
                        List<User> users = repository.getAllUsers();
                        for (User user : users) {
                    %>
                        <tr>
                            <td><%= user.getFirstName() %></td>
                            <td><%= user.getLastName() %></td>
                            <td><%= user.getEmail() %></td>
                            <td><%= user.getLastLogin() %></td>
                            <td><%= user.getRegisteredAt() %></td>
                        </tr>
                    <% } %>
                    </table>
            </div>
        </div>
        <div class = "row">
        <h1>Database Section</h1>
            <div class="column" style="background-color:#aaa;">
            <h2>Questions</h2>
                <form action="question-api" method="post">
                    <div class="form-outline mb-4">
                         <input type="submit" value="Add Questions" class="btn btn-primary btn-block" />
                    </div>
                    <table border="1" class="table table-striped table-hover w-50 p-3">
                        <tr>
                            <th>Number of questions in DB</th>
                        </tr>
                        <%
                            JpaQuestionRepository repo = new JpaQuestionRepository();
                        %>
                        <tr>
                            <td><%=repo.getNumberOfQuestions()%></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="column" style="background-color:#bbb;">
            <h1>generated Quizes</h1>
                 <table border="1" class="table table-striped table-hover w-50 p-3">
                      <tr>
                         <th>Number of quizes in DB</th>
                      </tr>
                      <%
                      JpaQuizRepository repo2 = new JpaQuizRepository();
                       %>
                       <tr>
                            <td><%=repo2.getNumberOfQuizes()%></td>
                       </tr>
                 </table>
            </div>
        </div>
        <div class = "row">
        <h1>Logout Section</h1>
            <form action="logout-api" method="get">
                <h3>Logout</h3>
                <div class="form-outline mb-4">
                    <input type="submit" value="Logout" class="btn btn-primary btn-block" />
                </div>
            </form>
        </div>
    </body>
</html>