<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 1/31/2023
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ điển</title>
</head>
<body>
<form action="translate" method="get">
  <fieldset>
    <h1>Từ điển Anh-Việt</h1>
    <table>
      <tr>
        <th><input type="text" name="english" value="${english}"></th>
        <th>Kết quả: ${result}</th>
      </tr>
      <tr>
        <th></th>
        <th>
          <button type="submit">Dịch</button>
        </th>
      </tr>
    </table>
    <a href="all-vocabulary"></a>
  </fieldset>
</form>
</body>
</html>
