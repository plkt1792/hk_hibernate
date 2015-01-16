<%@ page import="java.util.List" %>
<%@ page import="model.User" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: Pulkit.singh
  Date: 1/13/2015
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h1 align="center">List of Employees : </h1>
    <br><br>
    <table align="center" border="1">
        <tr>
            <td align="center"><b>USERNAME</b></td>
            <td align="center"><b>EMPLOYEE NAME</b></td>
            <td align="center"><b>MANAGER NAME</b></td>
        </tr>
    <%
        List<User> eList = (List<User>) request.getAttribute("list");
        for (Iterator it = eList.iterator(); it.hasNext();) {
            User user = (User)it.next();
            out.print("<tr>");
            out.print("<td align='center'>" + user.getUsername()+"</td>");
            out.print("<td align='center'>" + user.getName()+"</td>");
            out.print("<td align='center'>" + user.getManager()+"</td>");
            out.print("</tr>");
        }
    %>
    </table>
</body>
</html>
