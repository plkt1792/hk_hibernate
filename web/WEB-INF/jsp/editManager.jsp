<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Pulkit.singh
  Date: 1/14/2015
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Hello, ${username}</h2>
<form method="post" action="addManager.html">
    <table align="center">
        <tr>
            <td align="center"><b>Username</b></td>
            <td align="center"><input type="text" name="username"></td>
        </tr>
        <tr>
            <td align="center"><b>Manager Name</b></td>
            <td align="center"><input type="text" name="manager_name"></td>
        </tr>
        <tr>
            <td align="center" colspan="2"><input type="hidden" value="${username}" name="uname"><input type="submit" value="ADD"></td>
        </tr>
    </table>
</form>
<br><br>
<table align="center" border="2">
    <tr>
        <td><b>Username</b></td>
        <td><b>Manager Name</b></td>
        <td></td>
    </tr>
    <%
        List mList = (List)request.getAttribute("mlist");
        for (Iterator it = mList.iterator(); it.hasNext();) {
            User user = (User)it.next();
            out.print("<tr>");
            out.print("<td align='center'>"+user.getUsername()+"</td>");
            out.print("<td align='center'>"+user.getManager()+"</td>");
            out.print("<td align='center'><form method='post' action='delManager.html'>");
            out.print("<input type='hidden' value='"+user.getUsername()+"' name='username'>");
            out.print("<input type='hidden' value='"+user.getManager()+"' name='manager_name'>");
    %>
    <input type='hidden' value='${username}' name='uname'>
    <%
            out.print("<input type='submit' value='DELETE'></form></td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
