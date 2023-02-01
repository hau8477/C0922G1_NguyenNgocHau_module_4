<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="sandwich-condiments" method="post">
    <input type="checkbox" name="condiments" value="Lettuce">
    <span>Lettuce</span>
    <input type="checkbox" name="condiments" value="Tomato">
    <span>Tomato</span>
    <input type="checkbox" name="condiments" value="Mustard">
    <span>Mustard</span>
    <input type="checkbox" name="condiments" value="Sprouts">
    <span>Sprouts</span>
    <br>
    <button type="submit">Save</button>
</form>
<c:forEach var="condiment" items="${condiments}">
    <p>${condiment}</p>
</c:forEach>
</body>
</html>