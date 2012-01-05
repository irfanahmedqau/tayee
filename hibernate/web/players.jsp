<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="javax.naming.*" %>
<%@ page import="org.hibernate.*" %>

<%
    InitialContext ctx      = new InitialContext();
    SessionFactory factory  = (SessionFactory)
                              ctx.lookup("java:/hibernate/SessionFactory");
    Session        hsession = factory.openSession();
    try {
            Query query = hsession.createQuery("from org.jboss.roster.Player order by name");
        request.setAttribute("players", query.list());
    } finally {
        hsession.close();
    }
%>

<html>
<head><title>Players Page</title></head>
<body>
    <h1>All Players</h1>

    <table border="1">
        <tr>
           <th>Name</th>
           <th>Position</th>
           <th>Salary</th>
        </tr>
        <c:forEach items="${players}" var="player">
            <tr>
                <td>${player.name}</td>
                <td>${player.position}</td>
                <td>${player.salary}</td>
            </tr> 
        </c:forEach>
    <table>
</body>
</html>
