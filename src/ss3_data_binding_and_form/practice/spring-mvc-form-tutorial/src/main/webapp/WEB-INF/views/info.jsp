<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2/1/2023
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<table>
    <tr>
        <td>Name:</td>
        <td>${employee.getName()}</td>
    </tr>
    <tr>
        <td>ID:</td>
        <td>${employee.getId()}</td>
    </tr>
    <tr>
        <td>Contact Number:</td>
        <td>${employee.getContactNumber()}</td>
    </tr>
</table>
</body>
</html>
