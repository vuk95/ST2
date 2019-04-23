package com.example.products.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.products.domain.Orders;
import com.example.products.repository.OrdersRepository;
import com.example.products.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersRepository ordersRepository;
	
	@Override
	public void save(Orders order, String email) {
		order.setEmail(email);
		ordersRepository.save(order);		
	}

}
