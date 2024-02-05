package com.spring.web.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
import java.util.Set;
import java.util.stream.Collectors;
 
@Controller
public class DefaultController {
 
    @GetMapping("/")
    public String defaultAfterLogin(Authentication authentication) {
 
        Set<String> roles = authentication.getAuthorities().stream()
             .map(GrantedAuthority::getAuthority)
             .collect(Collectors.toSet());
 
        if (roles.contains("ROLE_ADMIN")) {
            return "redirect:/restaurant/restaurant";
        } else if (roles.contains("ROLE_CUSTOMER")) {
            return "redirect:/customer/restaurant";
        } else if (roles.contains("ROLE_DRIVER")) {
            return "redirect:/driver/dashboard";
        } else {
            return "redirect:/error";
        }
    }
}
