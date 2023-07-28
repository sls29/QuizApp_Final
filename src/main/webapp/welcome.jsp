<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

    <form action="logout-api" method="get">

        <h2>
            Hello
            <%=request.getParameter("name")%>!
        </h2>
        <h3>Welcome to QuizApp</h3>

        <br> <input type="submit" value="Logout" />
    </form>

</body>
</html>