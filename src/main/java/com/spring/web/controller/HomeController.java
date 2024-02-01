package com.spring.web.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.FoodItemService;
import com.spring.web.entity.FoodItem;
import com.spring.web.entity.Restaurant;
import com.spring.web.repository.RestaurantRepository;

//mapping for a customer user
@Controller
@RequestMapping("/customer")
public class HomeController {
	
    @Autowired
    private RestaurantRepository restaurantRepository;

    private final FoodItemService foodItemService;

    public HomeController(FoodItemService foodItemService){
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

/*
 * // CREATE: Display form to add a new restaurant
 * 
 * @GetMapping("/add") public ModelAndView showAddForm() { Restaurant restaurant
 * = new Restaurant(); // Assuming you have a default constructor return new
 * ModelAndView("addRestaurant", "restaurant", restaurant); }
 * 
 * // CREATE: Process the form to add a new restaurant
 * 
 * @PostMapping("/add") public String
 * addRestaurant(@ModelAttribute("restaurant") Restaurant restaurant) {
 * restaurantRepository.save(restaurant); return
 * "redirect:/customer/restaurant/"; }
 * 
 * // UPDATE: Display form to edit an existing restaurant
 * 
 * @GetMapping("/edit/{id}") public ModelAndView
 * showEditForm(@PathVariable("id") Integer id) { // id is changed to Integer
 * Optional<Restaurant> restaurant = restaurantRepository.findById(id); if
 * (!restaurant.isPresent()) { return new ModelAndView("redirect:/restaurant/");
 * } return new ModelAndView("editRestaurant", "restaurant", restaurant.get());
 * }
 * 
 * // UPDATE: Process the form to edit a restaurant
 * 
 * @PostMapping("/update/{id}") public String
 * updateRestaurant(@PathVariable("id") Integer
 * id, @ModelAttribute("restaurant") Restaurant restaurant) {
 * restaurant.setId(id); restaurantRepository.save(restaurant); return
 * "redirect:/customer/restaurant/"; }
 * 
 * /// DELETE: Remove a restaurant by its ID
 * 
 * @GetMapping("/delete/{id}") public String
 * deleteRestaurant(@PathVariable("id") Integer id) { // id is changed to
 * Integer restaurantRepository.deleteById(id); return
 * "redirect:/customer/restaurant/"; }
 * 
 * }
 * 
 */

// 	// READ: Get all foodItems
//     @GetMapping("/")
//     public ModelAndView getFoodItems() {
//         List<FoodItem> foodItems = foodItemRepository.findAll();
//         return new ModelAndView("foodItemList", "list", foodItems);
//     }

//     // CREATE: Display form to add a new foodItem
//     @GetMapping("/add")
//     public ModelAndView showAddForm() {
//         FoodItem foodItem = new FoodItem(); // Assuming you have a default constructor
//         return new ModelAndView("addFoodItem", "foodItem", foodItem);
//     }

//     // CREATE: Process the form to add a new foodItem
//     @PostMapping("/add")
//     public String addFoodItem(@ModelAttribute("foodItem") FoodItem foodItem) {
//         foodItemRepository.save(foodItem);
//         return "redirect:/foodItem/";
//     }

//     // UPDATE: Display form to edit an existing foodItem
//     @GetMapping("/edit/{id}")
//     public ModelAndView showEditForm(@PathVariable("id") long id) {
//         Optional<FoodItem> foodItem = foodItemRepository.findById(id);
//         if (!foodItem.isPresent()) {
//             return new ModelAndView("redirect:/foodItem/");
//         }
//         return new ModelAndView("editFoodItem", "foodItem", foodItem.get());
//     }

//     // UPDATE: Process the form to edit a foodItem
//     @PostMapping("/update/{id}")
//     public String updateFoodItem(@PathVariable("id") long id, @ModelAttribute("foodItem") FoodItem foodItem) {
//         foodItem.setId(id); // Required to update the existing food item rather than create a new one
//         foodItemRepository.save(foodItem);
//         return "redirect:/foodItem/";
//     }

//     // DELETE: Remove a foodItem by its ID
//     @GetMapping("/delete/{id}")
//     public String deleteFoodItem(@PathVariable("id") long id) {
//         foodItemRepository.deleteById(id);
//         return "redirect:/foodItem/";
//     }

	
	

// }
