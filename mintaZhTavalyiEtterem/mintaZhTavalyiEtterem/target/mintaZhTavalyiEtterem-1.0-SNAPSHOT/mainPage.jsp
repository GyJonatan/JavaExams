<%@ page import="oe.java.etterem.model.Etterem" %><%--
  Created by IntelliJ IDEA.
  User: gyurk
  Date: 2021. 11. 26.
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nagyon főoldal</title>
</head>
<body>
<h1>Foglalások</h1>
<h5>Bejelentkezve mint: <%=request.getSession().getAttribute("bejelentkezett").toString()%></h5><br/>
<%
    Etterem etterem = (Etterem) request.getServletContext().getAttribute("etterem");
%>
<table border="1">
<tr>
    <td></td>
    <% for(int i = 0; i < etterem.getIdopontok().length; i++) { %>
            <td><%=etterem.getIdopontok()[i]%></td>
    <% } %>
</tr>

    <% for(int i = 0; i < etterem.getNapok().length; i++) { %>
    <tr>
        <td><%=etterem.getNapok()[i]%></td>
        <% for(int j = 0; j < etterem.getIdopontok().length; j++) { %>
        <td>
            <%
                if (etterem.getFoglalasok()[i][j] == null) {
                    %><a href="ManageServlet?foglalas=ok&foglalasi=<%=i%>&foglalasj=<%=j%>">Foglalás</a><%
                } else if(etterem.getFoglalasok()[i][j].equals(request.getSession().getAttribute("bejelentkezett").toString())) {
                    %><a href="ManageServlet?torles=ok&foglalasi=<%=i%>&foglalasj=<%=j%>">Törlés</a><%
                } else {
                    %><p>Foglalt</p><%
                }


            %>
        </td>
        <%  } %>
    </tr>
      <%  } %>





</table>
</body>
</html>
