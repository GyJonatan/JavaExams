<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body background="https://media1.giphy.com/media/WCW7JbyCNmMUg/200.gif" style="background-size: 100%">
<%
    String message = (String) request.getAttribute("message");

%>
<h1>Hello
</h1>
<br/>
<form action="setup" method="get">
    email:<input type="text" name="email">
    <input type="submit" value="login">
</form><br>
<%=message%>
</body>
</html>