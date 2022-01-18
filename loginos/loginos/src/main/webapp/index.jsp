<%--
  Created by IntelliJ IDEA.
  User: gyurk
  Date: 2021. 12. 03.
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="/login" method="post">
    Email: <input type="text" name="email" value="teszt@teszt.com"><br>
    Password: <input type="password" name="password" value="teszt"><br>
    <input type="submit" value="Login"><br>
    <a href="register.jsp">Register</a>
</form>
</body>
</html>
