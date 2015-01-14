<%@ page import="java.util.Stack" %>

<%--
  Created by IntelliJ IDEA.
  User: Pulkit.singh
  Date: 1/14/2015
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Subordinates</title>
</head>
<body>
<h2>Hello, ${username}</h2>
<h3>Subordinates of Manager : ${manager}</h3>
<table align="center" border="1">
    <tr><td><b>Subordinates List</b></td></tr>
<%
    Stack<String> subList = (Stack<String>) request.getAttribute("subList");
    while (!subList.empty()){
        String sub = subList.pop();
        out.print("<tr><td>"+sub+"</td></tr>");
    }
%>
</table>
</body>
</html>
