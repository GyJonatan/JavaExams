<%@ page import="com.example.heeevakcina.model.ElojegyzesMenedzser" %>
<%@ page import="com.example.heeevakcina.model.Foglalas" %><%--
  Created by IntelliJ IDEA.
  User: gyurk
  Date: 2022. 01. 02.
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ElojegyzesMenedzser em=ElojegyzesMenedzser.getInstance();
Foglalas foglalas=em.FindByTaj(session.getAttribute("tajszam").toString());

%>


<html>
<head>
    <title>Előjegyzés</title>
</head>
<body>
<p>${requestScope.siker}</p>
<h1>Ön által választott időpont</h1>
<table>
    <tr>
        <td> TAJ: <%=ElojegyzesMenedzser.getInstance().FindByTaj(session.getAttribute("tajszam").toString()).tajSzam%></td>
    </tr>
    <tr>
        <td> Életkor: <%=ElojegyzesMenedzser.getInstance().FindByTaj(session.getAttribute("tajszam").toString()).eletkor%></td>
    </tr>
    <tr>
        <td>Vakcina: <%=ElojegyzesMenedzser.getInstance().FindByTaj(session.getAttribute("tajszam").toString()).vakcina%></td>
    </tr>
</table>
<a href="remove?tajszam=<%=foglalas.tajSzam%>&vakcina=<%=foglalas.vakcina%>">Törlés</a>
</body>
</html>
