package com.javamaster.spring.exp.handle.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javamaster.spring.exp.handle.api.exception.OrderServiceException;
import com.javamaster.spring.exp.handle.api.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;

	@GetMapping("/getPrice/{productName}")
	public String getOrderPrice(@PathVariable String productName) throws OrderServiceException {
		double amount = service.getPrice(productName);
		return "amount for product " + productName + " is " + amount;
	}
}
