package com.spring.web;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.web.repository.OrderRepository;
import com.spring.web.entity.Order;
import com.spring.web.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    //@Autowired
   // private CartService cartService; // Assuming you have a CartService to manage the shopping cart

    // Method to create a new order
    @Transactional
    public Order createOrder(User user, BigDecimal totalPrice, String status) {
        Order newOrder = new Order();
        newOrder.setUser(user); // Assuming the User entity has a field 'userId'
        newOrder.setTotalPrice(totalPrice);
        newOrder.setOrderDate(new Date()); // Sets the order date to the current date and time
        newOrder.setStatus(status);

        // Persist the new order to the database
        return orderRepository.save(newOrder);
    }

    // Method to find orders by user ID
    public List<Order> findOrdersByUser(String username) {
        return orderRepository.findByUser_Username(username);
    }

    // Method to update the status of an order
    @Transactional
    public Order updateOrderStatus(Integer orderId, String newStatus) {
        Order order = orderRepository.findById(orderId)
                                     .orElseThrow(() -> new IllegalStateException("Order not found"));
        order.setStatus(newStatus);
        return orderRepository.save(order);
    }

    // Additional methods as needed...
}