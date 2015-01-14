<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="model.Role" %>
<%--
  Created by IntelliJ IDEA.
  User: Pulkit.singh
  Date: 1/14/2015
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Role</title>
</head>
<body>
<h2>Hey, ${username}</h2>
    <form method="post" action="addRole.html">
    <table align="center">
      <tr>
          <td align="center"><b>Username</b></td>
          <td align="center"><input type="text" name="username"></td>
      </tr>
      <tr>
          <td align="center"><b>Rolename</b></td>
          <td align="center"><input type="text" name="rolename"></td>
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
            <td><b>Rolename</b></td>
            <td></td>
        </tr>
        <%
            List eList = (List)request.getAttribute("list");
            for (Iterator it = eList.iterator(); it.hasNext();) {
                Role user = (Role)it.next();
                out.print("<tr>");
                out.print("<td align='center'>"+user.getUsername()+"</td>");
                out.print("<td align='center'>"+user.getRolename()+"</td>");
                out.print("<td align='center'><form method='post' action='delRole.html'>");
                out.print("<input type='hidden' value='"+user.getUsername()+"' name='username'>");
                out.print("<input type='hidden' value='"+user.getRolename()+"' name='rolename'>");
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
