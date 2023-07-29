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
            { box-sizing: border-box; }

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
        <title>Administration page</title>
        <div class = "row">
            <div class="column" style="background-color:#bbb;">
                <h2>Registered Users</h2>
                <br/>
                <form action="/user-api" method="get">
                     <div class="form-outline mb-4">
                          <input type="submit" value="Delete User" class="btn btn-primary btn-block" />
                     </div>
                </form>
            </div>
            <div class="column" style="background-color:#aaa;">
            <h2>Registered Users</h2>
                <table border="1" class="table table-striped table-hover w-50 p-3">
                    <tr>
                        <th>ID</th>
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
                            <td><%= user.getId() %></td>
                            <td><%= user.getFirstName() %></td>
                            <td><%= user.getLastName() %></td>
                            <td><%= user.getEmail() %></td>
                            <td><%= user.getLastLogin() %></td>
                            <td><%= user.getRegisteredAt() %></td>
                        </tr>
                    <% } %>
                </table>
            </div>
        <div class = "row">
            <div class="column" style="background-color:#aaa;">
                <h2>Generated Quizes</h2>
                <br/>
                <form action="/user-api" method="get">
                    <div class="form-outline mb-4">
                         <input type="submit" value="Add Questions" class="btn btn-primary btn-block" />
                    </div>
                    <div class="form-outline mb-4">
                         <input type="submit" value="Generate Quizes" class="btn btn-primary btn-block" />
                    </div>
                </form>
            </div>
            <div class="column" style="background-color:#bbb;">
                <br/>
            </div>
        </div>

        <div class = "row">
            <form action="logout-api" method="get">
                <h3>Logout</h3>
                <br/>
                <div class="form-outline mb-4">
                    <input type="submit" value="Logout" class="btn btn-primary btn-block" />
                </div>
            </form>
        </div>
    </body>
</html>