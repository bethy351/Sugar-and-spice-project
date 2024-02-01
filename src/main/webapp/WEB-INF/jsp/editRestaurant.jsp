<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Restaurant</title>
</head>
<body>

<h2>Edit Restaurant</h2>

<!-- Assuming that RestaurantController's updateRestaurant() method is mapped to /restaurant/update/{id} -->
<c:url var="updateRestaurantAction" value="/restaurant/update/${restaurant.id}" />

<form action="${updateRestaurantAction}" method="post">
    <!-- Hidden field to pass id of the restaurant -->
    <input type="hidden" name="id" value="${restaurant.id}"/>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${restaurant.name}"/><br/>

    <label for="description">Description:</label>
    <input type="text" id="description" name="description" value="${restaurant.description}"/><br/>

    <label for="location">Location:</label>
    <input type="text" id="location" name="location" value="${restaurant.location}"/><br/>

    <label for="ratings">Ratings:</label>
    <input type="number" step="0.1" id="ratings" name="ratings" value="${restaurant.ratings}"/><br/>

    <input type="submit" value="Update Restaurant"/>
</form>

<a href="${pageContext.request.contextPath}/restaurant/restaurant">Back to List</a>

</body>
</html>