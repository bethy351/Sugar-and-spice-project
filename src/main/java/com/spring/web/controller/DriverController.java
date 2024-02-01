package com.spring.web.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@GetMapping("/dashboard")
	public String home() {
		return "Driver dashbaord - Coming soon!!!!";
	}
	
	

}