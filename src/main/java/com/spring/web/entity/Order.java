package com.spring.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



	
	
//	CREATE TABLE Cart (    
//			cart_id INT AUTO_INCREMENT PRIMARY KEY,    
//			user_id INT,    
//			food_item_id INT,    
//			quantity INT,    
//			FOREIGN KEY (user_id) REFERENCES User(UserId),    
//			FOREIGN KEY (food_item_id) REFERENCES food_item(food_item_id))
//	
//	;
//	
//	CREATE TABLE OrderDetails (    
//			order_details_id INT AUTO_INCREMENT PRIMARY KEY,    
//			order_id INT,    
//			food_item_id INT,    
//			quantity INT,    
//			FOREIGN KEY (order_id) 
//			REFERENCES Orders(order_id),    
//			FOREIGN KEY (food_item_id) REFERENCES food_item(food_item_id));
//	
//	CREATE TABLE Orders (    
//			order_id INT AUTO_INCREMENT PRIMARY KEY,    
//			user_id INT,    total_price DECIMAL(10,2),    
//			order_date DATETIME DEFAULT CURRENT_TIMESTAMP,   
//			status VARCHAR(50),    FOREIGN KEY (user_id) 
//			REFERENCES User(UserId));
	
	
	import javax.persistence.*;
	import java.math.BigDecimal;
	import java.util.Date;

	@Entity
	@Table(name = "Orders")
	public class Order {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "order_id")
	    private Integer id;

	    // Assuming you have a User entity with 'UserId' as the PK field
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	    private User user;

	    @Column(name = "total_price")
	    private BigDecimal totalPrice;

	    @Column(name = "order_date")
	    
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date orderDate;

	    @Column(name = "status")
	    private String status;

	    public Order() {
	        // Hibernate requires a no-arg constructor
	    }

	    // Getters and setters

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public User getUser() {
	        return user;
	    }
	    
	    public void setUser(User user) {
	        this.user = user;
	    }

	    public BigDecimal getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(BigDecimal totalPrice) {
	        this.totalPrice = totalPrice;
	    }

	    public Date getOrderDate() {
	        return orderDate;
	    }

	    public void setOrderDate(Date orderDate) { this.orderDate = orderDate;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
}

