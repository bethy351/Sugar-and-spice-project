package com.spring.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "food_item")
public class FoodItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_item_id") // Explicitly specify column name to match the database
    private Long id;

    @Column(name = "food_item_name") // Explicitly specify column name to match the database
    private String name;

    @Column(name = "food_item_desc") // Explicitly specify column name to match the database
    private String description;

    @Column(name = "food_item_price") // Explicitly specify column name to match the database
    private Double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id") // Define the foreign key column name used to join with the Restaurant table
    private Restaurant restaurant;

	public FoodItem() {}

	public FoodItem(String name, String description, Double price, Restaurant restaurant) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.restaurant = restaurant;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}