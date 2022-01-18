<%@ page import="com.example.loginos.model.User" %><%--
  Created by IntelliJ IDEA.
  User: gyurk
  Date: 2021. 12. 03.
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<h1>Members</h1>
<h2>Hello <%=((User)session.getAttribute("user")).getEmail()%></h2>
</body>
</html>
