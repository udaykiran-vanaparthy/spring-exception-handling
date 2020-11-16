package com.javamaster.spring.exp.handle.api.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamaster.spring.exp.handle.api.dao.OrderDAO;
import com.javamaster.spring.exp.handle.api.exception.OrderServiceException;
import com.javamaster.spring.exp.handle.api.model.Order;

@Service
public class OrderService {
	
	@Autowired
	private OrderDAO dao;

	@PostConstruct
	public void addOrder2DB() {
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(876, "TV", "Electronics", 86000));
		orders.add(new Order(806, "CAR", "Veichle", 1200000));
		dao.save(orders);
	}

	public double getPrice(String productName) throws OrderServiceException {
		Order order = null;
		double amount = 0;
		try {
			order = dao.findByName(productName);
			amount = order.getAmount();
		} catch (Exception e) {
			throw new OrderServiceException("order not found with product : " + productName);
		}
		return amount;
	}
}
