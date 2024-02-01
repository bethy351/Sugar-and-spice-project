/*
 * package com.spring.web.controller;
 * 
 * import java.util.List; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.*; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * import com.spring.web.entity.FoodItem; import
 * com.spring.web.repository.FoodItemRepository;
 * 
 * @Controller
 * 
 * @RequestMapping("/foodItem") public class FoodItemController {
 * 
 * @Autowired private FoodItemRepository foodItemRepository;
 * 
 * // READ: Get all foodItems
 * 
 * @GetMapping("/") public ModelAndView getFoodItems() { List<FoodItem>
 * foodItems = foodItemRepository.findAll(); return new
 * ModelAndView("foodItemList", "list", foodItems); }
 * 
 * // CREATE: Display form to add a new foodItem
 * 
 * @GetMapping("/add") public ModelAndView showAddForm() { FoodItem foodItem =
 * new FoodItem(); // Assuming you have a default constructor return new
 * ModelAndView("addFoodItem", "foodItem", foodItem); }
 * 
 * // CREATE: Process the form to add a new foodItem
 * 
 * @PostMapping("/add") public String addFoodItem(@ModelAttribute("foodItem")
 * FoodItem foodItem) { foodItemRepository.save(foodItem); return
 * "redirect:/foodItem/"; }
 * 
 * // UPDATE: Display form to edit an existing foodItem
 * 
 * @GetMapping("/edit/{id}") public ModelAndView
 * showEditForm(@PathVariable("id") long id) { Optional<FoodItem> foodItem =
 * foodItemRepository.findById(id); if (!foodItem.isPresent()) { return new
 * ModelAndView("redirect:/foodItem/"); } return new
 * ModelAndView("editFoodItem", "foodItem", foodItem.get()); }
 * 
 * // UPDATE: Process the form to edit a foodItem
 * 
 * @PostMapping("/update/{id}") public String updateFoodItem(@PathVariable("id")
 * long id, @ModelAttribute("foodItem") FoodItem foodItem) { foodItem.setId(id);
 * // Required to update the existing food item rather than create a new one
 * foodItemRepository.save(foodItem); return "redirect:/foodItem/"; }
 * 
 * // DELETE: Remove a foodItem by its ID
 * 
 * @GetMapping("/delete/{id}") public String deleteFoodItem(@PathVariable("id")
 * long id) { foodItemRepository.deleteById(id); return "redirect:/foodItem/"; }
 * 
 * 
 * }
 */