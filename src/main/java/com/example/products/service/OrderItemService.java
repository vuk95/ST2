package com.example.products.service;

import com.example.products.domain.OrderItem;
import com.example.products.domain.Product;

public interface OrderItemService {

	public OrderItem save(OrderItem item, Product prod);
	public OrderItem delete(Long id);
	
}
