package com.spring.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.FoodItemService;
import com.spring.web.entity.FoodItem;
import com.spring.web.entity.Restaurant;
import com.spring.web.repository.RestaurantRepository;

@Controller
@RequestMapping("/driver")
public class DriverController {
	
    @Autowired
    private RestaurantRepository restaurantRepository;

    private final FoodItemService foodItemService;

    public DriverController(FoodItemService foodItemService){
        this.foodItemService = foodItemService;
    }

	@GetMapping("/restaurant")
	public ModelAndView home() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return new ModelAndView("customerList", "list", restaurants);
    }


	 @GetMapping("/menu/{restaurantId}")
    public ModelAndView showMenu(@PathVariable Integer restaurantId){
        List<FoodItem> menuItems = foodItemService.findMenuItemsByRestaurantId(restaurantId);
        ModelAndView mav = new ModelAndView("menuItems");
        mav.addObject("menuItems", menuItems);
        mav.addObject("restaurantId", restaurantId);
        return mav;
    }
	 
}