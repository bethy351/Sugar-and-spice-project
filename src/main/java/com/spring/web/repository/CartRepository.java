package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.web.entity.Cart;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
//    List<Cart> findByUserId(Integer userId);
 
    List<Cart> findByUser_Username(String username);
       
    }
    

