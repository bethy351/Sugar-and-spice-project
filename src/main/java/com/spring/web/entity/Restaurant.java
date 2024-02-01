package com.spring.web.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "restaurant") // The table name is in all lowercase, assuming your DB is case-sensitive
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id") // Column names are now in snake_case to match your SQL table
    private Integer id;

    @Column(name = "restaurant_name")
    private String name;

    @Column(name = "restaurant_desc", columnDefinition = "TEXT")
    private String description;

    @Column(name = "restaurant_location")
    private String location;

    @Column(name = "restaurant_ratings")
    private Float ratings;

    @OneToMany(mappedBy = "restaurant")
    private Set<FoodItem> foodItems;

    // No-argument constructor
    public Restaurant() {
        // No-argument constructor
    }

    // Parameterized constructor for convenience
    public Restaurant(String name, String description, String location, Float ratings) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.ratings = ratings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getRatings() {
        return ratings;
    }

    public void setRatings(Float ratings) {
        this.ratings = ratings;
    }

    public Set<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(Set<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    
}