package com.example.products.service;

import com.example.products.domain.Orders;

public interface OrdersService {
	
	void save(Orders order, String email);

}
