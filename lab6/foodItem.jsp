<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="css/app.css">
</head>
<body>
    <ul>
    <c:forEach items="${list}" var="entry">
    <li>${entry.foodName} - ${entry.description} - ${entry.price}</li>
    </c:forEach>
    </ul>

    <a href="foodItems/create">Add new food</a>
</body>
</html>