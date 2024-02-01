package com.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.Bean;

//import com.spring.web.entity.FoodItem;
//import com.spring.web.entity.Restaurant;
import com.spring.web.repository.FoodItemRepository;

@SpringBootApplication
public class SpringWebApplication extends SpringBootServletInitializer {

    @Autowired
    private FoodItemRepository repo;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringWebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class, args);
    }

    // @Bean
    // public CommandLineRunner initDB() {
    //     return (args) -> {
    //         repo.save(new FoodItem("Double Cheeseburger", "Double layered cheeseburger with lettuce and tomato", 5.99, new Restaurant("Burger King", "Fast food restaurant chain", "New York", 4.2f)));
    //         repo.save(new FoodItem("Margherita Pizza", "Classic pizza with fresh tomatoes, mozzarella, and basil", 10.50, new Restaurant("Pizza Hut", "American pizza chain", "California", 4.4f)));
    //         repo.save(new FoodItem("Vegetable Lo Mein", "Stir-fried noodles with fresh vegetables", 8.95, new Restaurant("Great Wall", "Chinese takeout", "Texas", 4.1f)));
    //     };
    // }

}