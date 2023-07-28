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

    /* Create two equal columns that floats next to each other */
    .column {
      float: left;
      width: 50%;
      padding: 10px;
      height: 300px;
    }

    /* Clear floats after the columns */
    .row:after {
      content: "";
      display: table;
      clear: both;
    }
    </style>

    </head>

<body>
    <div class="row">
        <div class="column" style="background-color:#bbb;">
            <h2>User Login</h2>
                <form action="login-api" method="POST">
                    <br/>
                    <div class="form-outline mb-4">
                        <input type="text" name="eemail" value="Email..." onclick="this.value=''"/><br/>
                    </div>
                    <div class="form-outline mb-4">
                        <input type="password" name="ppassword"  value="Password..." onclick="this.value=''"/><br/>
                    </div>
                    <br/>
                        <input type="submit" value="Login" class="btn btn-primary btn-block"/>
                </form>
        </div>
        <div class="column" style="backgroud-color:#aaa;">
            <h2>User Registration</h2>
                <form action="user-api" method="POST">
                    <br/>
                    <div class="form-outline mb-4">
                        <input type="text" name="firstName" value="firstName..." onclick="this.value=''"/><br/>
                    </div>
                    <div class="form-outline mb-4">
                        <input type="text" name="lastName"  value="lastName..." onclick="this.value=''"/><br/>
                    </div>
                    <div class="form-outline mb-4">
                        <input type="text" name="email" value="Email..." onclick="this.value=''"/><br/>
                    </div>
                    <div class="form-outline mb-4">
                       <input type="text" name="password"  value="Password..." onclick="this.value=''"/><br/>
                    </div>
                    <div class="form-outline mb-4">
                       <input type="text" name="password2"  value="Password..." onclick="this.value=''"/><br/>
                    </div>
                    <br/>
                        <input type="submit" value="userRegistration" class="btn btn-primary btn-block"/>
                </form>
        </div>
    </div>

</body>
</html>
