<%--
  Created by IntelliJ IDEA.
  User: Pulkit.singh
  Date: 1/12/2015
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="login.html" method="post">
    <table>
        <tr>
            <td align="center"><b>Username</b></td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td align="center"><b>Password</b></td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td align="center"><input type="submit" value="Login" ></td>
            <td align="center"><a href="register.jsp">Sign Up!</a></td>
        </tr>
    </table>
</form>
</body>
</html>
