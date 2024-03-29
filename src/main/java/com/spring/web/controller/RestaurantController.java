package com.spring.web.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.spring.web.CartService;
import com.spring.web.FoodItemService;
import com.spring.web.entity.Cart;
import com.spring.web.entity.FoodItem;
import com.spring.web.entity.Restaurant;
import com.spring.web.entity.User;
import com.spring.web.repository.RestaurantRepository;

//@PreAuthorize("hasRole('ADMIN')")
@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;

	private final FoodItemService foodItemService;

	@Autowired
	private CartService cartService;

	@GetMapping("/cart")
    public ModelAndView viewCart(HttpSession session) {
        User user = (User) session.getAttribute("loggedUser"); // Get user from session
        List<Cart> cartItems = cartService.getCartItems(user);
        ModelAndView mav = new ModelAndView("cart");
        mav.addObject("cartItems", cartItems);
        return mav;
    }

    // Method to add an item to the cart
    @PostMapping("/cart/add")
    public String addToCart(
            @RequestParam("foodItemId") Integer foodItemId,
            @RequestParam("quantity") Integer quantity,
            HttpSession session) {
        User user = (User) session.getAttribute("loggedUser"); // Get user from session
        List<FoodItem> foodItem = foodItemService.findFoodItemById(foodItemId); // Assumed method
        cartService.addOrUpdateItem(user, foodItem, quantity);
        return "redirect:/restaurant/cart";
    }

	public RestaurantController(FoodItemService foodItemService) {
		this.foodItemService = foodItemService;
	}

	@GetMapping("/restaurant")
	public ModelAndView home() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return new ModelAndView("restaurantList", "list", restaurants);
	}

	@GetMapping("/menu/{restaurantId}")
	public ModelAndView showMenu(@PathVariable Integer restaurantId) {
		List<FoodItem> menuItems = foodItemService.findMenuItemsByRestaurantId(restaurantId);
		ModelAndView mav = new ModelAndView("menuItems");
		mav.addObject("menuItems", menuItems);
		mav.addObject("restaurantId", restaurantId);
		return mav;
	}

	// CREATE: Display form to add a new restaurant
	@GetMapping("/add")
	public ModelAndView showAddForm() {
		Restaurant restaurant = new Restaurant(); // Assuming you have a default constructor
		return new ModelAndView("addRestaurant", "restaurant", restaurant);
	}

	// CREATE: Process the form to add a new restaurant
	@PostMapping("/add")
	public String addRestaurant(@ModelAttribute("restaurant") Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		return "redirect:/restaurant/restaurant/";
	}

	// UPDATE: Display form to edit an existing restaurant
	@GetMapping("/edit/{id}")
	public ModelAndView showEditForm(@PathVariable("id") Integer id) { // id is changed to Integer
		Optional<Restaurant> restaurant = restaurantRepository.findById(id);
		if (!restaurant.isPresent()) {
			return new ModelAndView("redirect:/restaurant/");
		}
		return new ModelAndView("editRestaurant", "restaurant", restaurant.get());
	}

	// UPDATE: Process the form to edit a restaurant
	@PostMapping("/update/{id}")
	public String updateRestaurant(@PathVariable("id") Integer id,
			@ModelAttribute("restaurant") Restaurant restaurant) {
		restaurant.setId(id);
		restaurantRepository.save(restaurant);
		return "redirect:/restaurant/restaurant/";
	}

	/// DELETE: Remove a restaurant by its ID
	@GetMapping("/delete/{id}")
	public String deleteRestaurant(@PathVariable("id") Integer id) { // id is changed to Integer
		restaurantRepository.deleteById(id);
		return "redirect:/restaurant/restaurant/";
	}

}
