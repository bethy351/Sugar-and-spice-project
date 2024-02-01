<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Items</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
        }
        th {
            text-align: left;
        }
        table {
            width: 100%;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<h1>Menu Items</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Actions</th> <!-- For edit/delete if needed -->
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${menuItems}" var="foodItem">
            <tr>
                <td>${foodItem.id}</td>
                <td>${foodItem.name}</td>
                <td>${foodItem.description}</td>
                <td>${foodItem.price}</td>
                <td>
                    <!-- These links should point to the appropriate controller methods for edit and delete
                    <a href="${pageContext.request.contextPath}/foodItem/edit/${foodItem.id}">Edit</a> |
                    <a href="${pageContext.request.contextPath}/foodItem/delete/${foodItem.id}" onclick="return confirm('Are you sure?')">Delete</a> -->
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>