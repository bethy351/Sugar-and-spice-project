<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sugar & Spice: Restaurants</title>
</head>
<body>


<hr>
<h1>
    Sugar & Spice
</h1>
<!-- Restaurant List Table -->
<h2>Restaurants:</h2>
<table style="border: solid 1px darkorchid">
    <thead style="border: solid 1px darkorchid">
        <tr style="border: solid 1px darkorchid">
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Location</th>
            <th>Ratings</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${list}" var="restaurant">
            <tr style="border: solid 1px darkorchid">
                <td>${restaurant.id}</td>
                <td>${restaurant.name}</td>
                <td>${restaurant.description}</td>
                <td>${restaurant.location}</td>
                <td>${restaurant.ratings}</td>
                <td>
                    
                        <!-- Menu Link -->
                        <a href="${pageContext.request.contextPath}/restaurant/menu/${restaurant.id}">View Menu</a>
                   
                    <!-- Edit Link -->
                    <a href="${pageContext.request.contextPath}/restaurant/edit/${restaurant.id}">Edit</a>
                    <!-- Delete Link -->
                    <a href="${pageContext.request.contextPath}/restaurant/delete/${restaurant.id}"
                       onclick="return confirm('Are you sure you want to delete this restaurant?');">Delete</a>
                </td>
            </tr>
        </c:forEach>

        
    </tbody>
</table>
<!-- Add Restaurant Form -->
<c:url var="addRestaurantAction" value="/restaurant/add" />
<form action="${addRestaurantAction}" method="post">
  <h2>Add Restaurant:</h2>
  <div>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" />
  </div>
  <div>
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" />
  </div>
  <div>
    <label for="location">Location:</label>
    <input type="text" id="location" name="location" />
  </div>
  <div>
    <label for="ratings">Ratings:</label>
    <input type="number" step="0.1" id="ratings" name="ratings" />
  </div>
  <input type="submit" value="Add Restaurant" />
</form>
</body>
</html>