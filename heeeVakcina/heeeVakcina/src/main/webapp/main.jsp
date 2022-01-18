<%--
  Created by IntelliJ IDEA.
  User: gyurk
  Date: 2022. 01. 02.
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Előjegyzés</title>
</head>
<body>
<p>${requestScope.notregisted}</p>
<p>${requestScope.error}</p>
<p>${requestScope.torolve}</p>
<h1>Előjegyzés</h1>
<form method="post" action="/elojegyzes">
    TAJ:<input type="number" name="tajszam" max="999999999"/><br/>
    Életkor:<input type="number" name="eletkor" max="99" min="10"/><br/>
    Vakcina:
    <select name="vakcina">
    <option>Szputnyik</option>
    <option>Astra</option>
    <option>Pfizer</option>
    <option>Kínai</option>
</select>
    <input type="submit" value="Küldés"/><br/>
</form>
</body>
</html>
