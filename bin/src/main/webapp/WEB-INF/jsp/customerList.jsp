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
                        <a href="${pageContext.request.contextPath}/customer/menu/${restaurant.id}">View Menu</a>
                   
                
                </td>
            </tr>
        </c:forEach>

        
    </tbody>
</table>

</body>
</html>