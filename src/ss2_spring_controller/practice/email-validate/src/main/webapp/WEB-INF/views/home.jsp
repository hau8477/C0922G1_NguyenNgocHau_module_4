<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2/1/2023
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validate Email</title>
</head>
<body>
<h1>Email Validate</h1>
<h3 style="color:red">${message}</h3>
<form action="/validate" method="post">
    <input type="text" name="email"><br>
    <button type="submit">Validate</button>
</form>
</body>
</html>
