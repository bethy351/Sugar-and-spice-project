package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import com.spring.web.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    List<FoodItem> findMenuItemsByRestaurantId(Integer restaurantId);
}