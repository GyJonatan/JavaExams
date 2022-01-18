<%--
  Created by IntelliJ IDEA.
  User: gyurk
  Date: 2021. 12. 30.
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Korona oltáááááás</title>
</head>
<body>
<p>${requestScope.error}</p>
<h1>TAJ-szám megadás</h1>
<form method="post" action="/taj">
    TAJ szám:<input type="number" name="tajszam" max="999999999"/><br/>
    <input type="submit" value="Megadás"><br/>
</form>
</body>
</html>
