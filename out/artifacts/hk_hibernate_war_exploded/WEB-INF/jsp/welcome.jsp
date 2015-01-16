<%--
  Created by IntelliJ IDEA.
  User: Pulkit.singh
  Date: 1/9/2015
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h3>Hello, ${username}</h3>
<br><br>
    <table align="center">
        <tr>
            <td align="center">
                <form method="post" action="edit.html">
                    <input type="hidden" value='${username}' name="uname">
                    <input type="submit" value="EDIT EMPLOYEE ROLES">
                </form>
            </td>
        </tr>
        <tr>
            <td align="center">
                <form method="post" action="editM.html">
                    <input type="hidden" value='${username}' name="uname">
                    <input type="submit" value="EDIT MANAGER DETAILS">
                </form>
            </td>
        </tr>
        <tr>
            <td align="center">
                <form method="post" action="delete.html">
                    <input type="hidden" value='${username}' name="uname">
                    <input type="submit" value="DELETE EMPLOYEE DETAILS">
                </form>
            </td>
        </tr>
        <tr>
            <td align="center">
                <form method="post" action="view.html">
                    <input type="hidden" value='${username}' name="uname">
                    <input type="submit" value="VIEW EMPLOYEE DETAILS">
                </form>
            </td>
        </tr>
        <tr>
            <td align="center">
                <form method="get" action="/rest/service/user">
                    <input type="submit" value="VIEW EMPLOYEE DETAILS (in JSON form)">
                </form>
            </td>
        </tr>
        <tr>
            <td align="center">
                <form method="post" action="sub.html">
                    <input type="text" name="manager">
                    <input type="hidden" value='${username}' name="uname">
                    <input type="submit" value="VIEW ALL SUBORDINATES">
                </form>
            </td>
        </tr>
        <tr>
            <td align="center">
                <form method="post" action="register.jsp">
                    <input type="submit" value="CREATE EMPLOYEE ACCOUNT">
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
