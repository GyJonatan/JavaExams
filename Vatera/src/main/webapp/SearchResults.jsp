<%@ page import="com.example.vatera.model.Hirdető" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.vatera.model.Termek" %><%--
  Created by IntelliJ IDEA.
  User: gyurk
  Date: 2021. 11. 19.
  Time: 17:26
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
    if (request.getParameter("search")!=null)
    {
        request.getSession().setAttribute("Search",request.getParameter("search"));
    }
    String search = (String) request.getSession().getAttribute("Search");
%>

<table border="1">
    <th>Eladó</th>
    <th>Termék</th>
    <th>Tipus</th>
    <th>Ár</th>
    <th>Azonosito</th>
    <th>Foglalás</th>
<%
    for (Hirdető hirdető: hirdetok)
    {
        for (Termek termek: hirdető.getTermeks())
        {
            if (termek.getKeyWord().equals(search))
            {%>
                <tr>
                    <td><%=hirdető.getEmail()%></td>
                    <td><%=termek.getName()%></td>
                    <td><%=termek.getKeyWord()%></td>
                    <td><%=termek.getPrice()%></td>
                    <td><%=termek.getHash()%></td>
                    <% if (termek.getFoglalas()==null)
                    {%>
                    <td><a href="manager?Add=<%=termek.getHash()%>">Foglalas</a></td>
                    <%}
                    else if (termek.getFoglalas()==user.getEmail())
                    {%>
                    <td><a href="manager?Remove=<%=termek.getHash()%>">Törlés</a></td>
                    <%}
                    else
                    {%>
                    <td>Foglalt</td>
                    <%}
                    %>
                </tr>
            <%}
        }
    }%>
</table>
<a href="Webpage.jsp">Back</a>
</body>
</html>
