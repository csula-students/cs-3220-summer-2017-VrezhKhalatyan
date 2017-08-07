
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/app.css">
</head>
<body>
<div id="header">
    <a href="/">Main</a>
</div>
<table>
    <tbody>
    <c:forEach items="${list}" var="order">
        <tr>
            <td><c:out value="${order.id}"/></td>
            <td><c:out value="${order.customerName}"/></td>
            <td><c:out value="${order.created}"/></td>
            <a href="foodItems/order">Add to order</a>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>