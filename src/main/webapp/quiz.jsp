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

                body {
                    background-image: url("https://pilbox.themuse.com/image.jpg?filter=antialias&h=350&opt=1&pos=top-left&prog=1&q=keep&url=https%3A%2F%2Fcms-assets.themuse.com%2Fmedia%2Flead%2Fjob-burnout-quiz-06172022-1251371646-Mohd-Hafiez-Mohd-Razali-EyeEm.jpg&w=700");
                }
            { box-sizing: border-box;}

            .column {
                float: left;
                width: 40%;
                padding: 10px;
                height: 300px;
                margin: 10px:
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
            <div class = "column">
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
            <div class = "column">
                <div style = "height: 100px">
                    <img src = "data:image/jpeg;base64,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" onload = "loadedFunc()" />
               </div>
            </div>
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
                <form action="take.jsp" method="post">
                    <div class="form-outline mb-4">
                        <input type="text" name="quizName" value="EasyQuiz" onclick="this.value=''"/><br/>
                    </div>
                    <div class="form-outline mb-4">
                        <input type="submit" value="Play" class="btn btn-primary btn-block" />
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>