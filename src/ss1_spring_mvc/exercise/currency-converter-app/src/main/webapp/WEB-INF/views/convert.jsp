<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 1/31/2023
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyển đổi tiền tệ</title>
</head>
<body>
<form action="convert" method="get">
    <fieldset>
        <h1> Chuyển đổi tiền tệ</h1>
        <table>
            <tr>
                <th><label>Nhập số tiền USD</label></th>
                <th><input type="number" name="usd"></th>
            </tr>
            <tr>
                <th><label>Nhập tỉ giá</label></th>
                <th><input type="number" name="vnd"></th>
            </tr>
            <tr>
                <th></th>
                <th>
                    <button type="submit">Chuyển đổi</button>
                </th>
            </tr>
            <tr>
                <th>Kết quả: ${result} VNĐ</th>
            </tr>
        </table>

    </fieldset>
</form>
</body>
</html>
