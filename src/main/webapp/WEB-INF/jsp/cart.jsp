<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h2>Your Cart</h2>
<c:if test="\${not empty cartItems}">
    <table>
        <thead>
        <tr>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="\${cartItems}" var="cartItem">
            <tr>
                <td>\${cartItem.foodItem.foodItemName}</td>
                <td>\${cartItem.quantity}</td>
                <td>\${cartItem.foodItem.foodItemPrice}</td>
                <td>\${cartItem.foodItem.foodItemPrice * cartItem.quantity}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="\${empty cartItems}">
    <p>Your cart is empty.</p>
</c:if>
<a href="<c:url value='/restaurant/menu'/>">Continue Shopping</a>
</body>
</html>