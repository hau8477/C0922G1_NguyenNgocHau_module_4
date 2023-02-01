<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="get">
    <label>
        <input type="number" name="number1" value="${number1}">
    </label>
    <label>
        <input type="number" name="number2" value="${number2}">
    </label>
    <button type="submit" name="action" value="addition">Addition(+)</button>
    <button type="submit" name="action" value="subtraction">Subtraction(-)</button>
    <button type="submit" name="action" value="multiplication">Multiplication(*)</button>
    <button type="submit" name="action" value="division">Division(/)</button>
</form>
<h2>Result ${action}: ${result}</h2>
</body>
</html>