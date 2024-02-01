package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.web.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}