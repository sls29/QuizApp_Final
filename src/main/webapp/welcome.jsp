<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="com.QuizApp.repository.JpaUserRepository" %>
<%@ page import="com.QuizApp.model.User" %>
<%@ page import="java.time.LocalDateTime" %>

<html>
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Quiz Application</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.21.4/dist/bootstrap-table.min.css">

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <style>
        {
            box-sizing: border-box;
        }
        </style>

        <title>Welcome Page</title>
    </head>

    <body>
        <div class = "row">
            <form action="logout-api" method="get">
                <h2>Hello <%=request.getParameter("email")%>!</h2>
                <h3>Welcome to QuizApp</h3>
                <br/>
                <div class="form-outline mb-4">
                    <input type="submit" value="Logout" class="btn btn-primary btn-block" />
                </div>
            </form>
        </div>
    </body>
</html>