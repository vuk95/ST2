package com.example.products.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.products.domain.Orders;
import com.example.products.domain.User;
import com.example.products.service.OrdersService;
import com.example.products.service.UserService;

@RestController
public class OrderController {

	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/order/add", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> addOrder(){
		
		Orders order = new Orders();
		
		User loggedUser = userService.findByEmail("vuk.novakovic@pbssolutions.net");
		
		ordersService.save(order, loggedUser.getEmail());
		
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
}
