package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.web.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    // Find orders by user id
	List<Order> findByUser_Username(String username);

    // You can define other methods to retrieve orders based on various criteria.
    // For example, to find orders with a specific status:
    List<Order> findByStatus(String status);

    // To find orders within a certain date range, you could use:
    // List<Order> findByOrderDateBetween(Date startDate, Date endDate);
}