package com.spring.web;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.web.repository.FoodItemRepository;
import com.spring.web.entity.FoodItem;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemService(FoodItemRepository foodItemRepository){
        this.foodItemRepository = foodItemRepository;
    }
    
    public List<FoodItem> findMenuItemsByRestaurantId(Integer restaurantId) {
        // This uses the method from the FoodItemRepository
        return foodItemRepository.findMenuItemsByRestaurantId(restaurantId);
    }
}