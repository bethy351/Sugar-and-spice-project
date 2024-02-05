package com.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}