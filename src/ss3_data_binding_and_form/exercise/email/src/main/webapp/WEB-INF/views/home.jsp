<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2/2/2023
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gmail</title>
</head>
<body>
<table style="border: 1px">
    <thead>
    <tr>
        <td>Languages</td>
        <td>Page size</td>
        <td>Spams filter</td>
        <td>Signature</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="email" items="${emails}">
        <tr>
            <td>${email.languages}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>
            <td><a href="edit-email?id=${email.id}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
