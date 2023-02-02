<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2/2/2023
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<form:form action="/update" method="post" modelAttribute="newEmail">
    <fieldset>
        <legend>Settings</legend>
        <table>
            <tr><form:hidden path="id" value="${email.getId()}"></form:hidden></tr>
            <tr>
                <td>Languages:</td>
                <td>
                    <form:select path="languages">
                        <form:option value="English">English</form:option>
                        <form:option value="Vietnamese">Vietnamese</form:option>
                        <form:option value="Japanese">Japanese</form:option>
                        <form:option value="Chinese">Chinese</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Page size:</td>
                <td>
                    Show
                    <form:select path="pageSize">
                        <form:option value="5">5</form:option>
                        <form:option value="10">10</form:option>
                        <form:option value="15">15</form:option>
                        <form:option value="25">25</form:option>
                        <form:option value="50">50</form:option>
                        <form:option value="100">100</form:option>
                    </form:select>
                    email per page
                </td>
            </tr>
            <tr>
                <td>Spams filter</td>
                <td>
                    <form:radiobutton path="spamsFilter" value="true"></form:radiobutton>Enable spams filter
                </td>
            </tr>
            <tr>
                <td>Signature</td>
                <td>
                    <form:textarea path="signature"></form:textarea>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <form:button>Update</form:button>
                </td>
                <td>
                    <form:button><a href="/email">Cancel</a></form:button>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
