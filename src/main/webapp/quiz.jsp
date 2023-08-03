<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.QuizApp.repository.JpaUserRepository" %>
<%@ page import="com.QuizApp.repository.JpaQuizRepository" %>
<%@ page import="com.QuizApp.model.User" %>
<%@ page import="com.QuizApp.model.Quiz" %>
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
            { box-sizing: border-box;}

            .column {
                float: left;
                width: 50%;
                padding: 10px;
                height: 300px;
            }

            .row:after {
                content: "";
                display: table;
                clear: both;
            }
        </style>
    </head>
    <body>
        <title>Quiz's</title>
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
                 <h2><%=firstName%> session</h2>

            <form action="welcome.jsp" method="get">
                 <div class="form-outline mb-4">
                    <input type="submit" value="Go to Welcome Page" class="btn btn-primary btn-block" />
                 </div>
            </form>
        </div>

        <div class = "row">
            <div class = "column" style="background-color:#bbb;">
                    <h2>Choose a Quiz</h2>
                    <table border="1" class="table table-striped table-hover w-50 p-3">
                         <tr>
                              <th>QuizName</th>
                                  </tr>
                                        <%
                                            JpaQuizRepository repo = new JpaQuizRepository();
                                            List<Quiz> quizes = repo.getQuizes();
                                            for (Quiz quiz : quizes) {
                                        %>
                                            <tr>
                                                <td><%= quiz.getTitle() %></td>
                                            </tr>
                                        <% } %>
                    </table>
            </div>
            <div class = "column" style="background-color:#aaa;">
                <h2>Play Quiz</h2>
                <form action="quiz-api" method="POST">
                    <div class="form-outline mb-4">
                        <input type="text" name="quizName" value="QuizName..." onclick="this.value=''"/><br/>
                    </div>
                    <div class="form-outline mb-4">
                        <input type="submit" value="Play" class="btn btn-primary btn-block" />
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>