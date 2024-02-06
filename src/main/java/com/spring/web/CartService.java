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

    
	
	public List<Cart> getCartItems(String username) {
        return cartRepository.findByUser_Username(username);
    }

    @Transactional
    public void clearCart(String username) {
        List<Cart> cartItems = cartRepository.findByUser_Username(username);
        cartRepository.deleteAll(cartItems);
    }

    public Cart addOrUpdateItem(User user, List<FoodItem> foodItem, Integer quantity) {
        return addOrUpdateItem(user, foodItem, quantity);
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