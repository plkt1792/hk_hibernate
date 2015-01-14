<%--
  Created by IntelliJ IDEA.
  User: Pulkit.singh
  Date: 1/13/2015
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<h1>Hey, ${username}</h1>
    <h2>Delete Employee Record</h2>
    <form method="post" action="deleteEmp.html">
        Enter Employee username : <input type="text" name="ename">
        <input type="hidden" value="${username}" name="uname">
        <input type="submit" value="DELETE">
    </form>
</body>
</html>
