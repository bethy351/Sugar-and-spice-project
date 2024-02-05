package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.web.entity.Cart;
import com.spring.web.entity.FoodItem;
import com.spring.web.entity.User;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
//    List<Cart> findByUserId(Integer userId);
 
    List<Cart> findByUser_Username(String username);
       
    }
    

