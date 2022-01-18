<%--
  Created by IntelliJ IDEA.
  User: gyurk
  Date: 2021. 12. 03.
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="/register" method="post">
    <i style="display: <%=session.getAttribute("displayerror")%>">Email address already registered!</i><br>
    Email: <input type="text" name="email"/><br>
    Password: <input type="password" name="password"/><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
