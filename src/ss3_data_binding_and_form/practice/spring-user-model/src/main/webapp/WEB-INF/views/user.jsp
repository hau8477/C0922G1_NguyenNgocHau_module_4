<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2/2/2023
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h1>Welcome</h1>
<h3>Account: ${user.getAccount()}</h3>
<h3>Name: ${user.getName()}</h3>
<h3>Email: ${user.getEmail()}</h3>
<h3>Age: ${user.getAge()}</h3>
</body>
</html>
