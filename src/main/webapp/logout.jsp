<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.QuizApp.repository.JpaUserRepository" %>
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
        { box-sizing: border-box;}
        </style>

    </head>

    <body>
        <div class = "row">
            <div class = "column" style="background-color:#ffffff;">
                <h2>Goodbye!</h2>
                <br/>
            </div>
        </div>
        <div class = "row">
            <div class = "column" style="background-color:#ffffff;">
            <form action="index.jsp" method="get">
                <h3>Go to Login Page</h3>
                <br/>
                <div class="form-outline mb-4">
                    <input type="submit" value="Go to Login" class="btn btn-primary btn-block" />
                </div>
            </form>
            </div>
        </div>
    </body>
</html>