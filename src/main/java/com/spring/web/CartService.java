package com.spring.web;

import com.spring.web.entity.Cart;
import com.spring.web.entity.FoodItem;
import com.spring.web.entity.User;
import com.spring.web.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public CartService(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	@Transactional
	public Cart addOrUpdateItem(User user, FoodItem foodItem, Integer quantity) {
		// Find existing cart item
		List<Cart> existingItems = cartRepository.findByUser_Username(user.getUsername());
		Cart cart;
		if (!existingItems.isEmpty()) {
			// Update existing cart item
			cart = existingItems.get(0);
			cart.setQuantity(cart.getQuantity() + quantity);
		} else {
			// Create new cart item
			cart = new Cart(user, foodItem, quantity);
			cart.setUser(user);
			cart.setFoodItem(foodItem);
			cart.setQuantity(quantity);
		}
		return cartRepository.save(cart);
	}

	// Method to get cart items for a given user
	public List<Cart> getCartItems(User user) {
		return cartRepository.findByUser_Username(user.getUsername());
	}

	// Method to clear the cart for a given user
	@Transactional
	public void clearCart(User user) {
		List<Cart> cartItems = cartRepository.findByUser_Username(user.getUsername());
		cartRepository.deleteAll(cartItems);
	}

	// ... additional cart methods as needed ...
}