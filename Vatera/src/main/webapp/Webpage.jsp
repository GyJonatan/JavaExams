<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.vatera.model.Hirdető" %>
<%@ page import="com.example.vatera.model.Termek" %><%--
  Created by IntelliJ IDEA.
  User: gyurk
  Date: 2021. 11. 19.
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Hirdető user = (Hirdető) request.getSession().getAttribute("user");
    ArrayList<Hirdető> hirdetok = (ArrayList<Hirdető>)request.getServletContext().getAttribute("Hirdetok");
%>
<h1>csumi</h1>
<table border="1">
    <th>termek</th>
    <th>kulcs</th>
    <th>ár</th>
    <th>foglalas</th>
    <%for (Termek termek: user.getTermeks()) { %>
    <tr>
        <td><%=termek.getName()%></td>
        <td><%=termek.getKeyWord()%></td>
        <td><%=termek.getPrice()%></td>
        <td><%=termek.getFoglalas()%></td>
    <tr/>
    <%}%>
</table>
<br>
<form action="SearchResults.jsp" method="get">
    <select name="search">
        <option><%=Termek.getKeywordArray().get(0)%></option>
        <option><%=Termek.getKeywordArray().get(1)%></option>
        <option><%=Termek.getKeywordArray().get(2)%></option>
    </select>
    <input type="submit" value="Keresés">
</form>


</body>
</html>
