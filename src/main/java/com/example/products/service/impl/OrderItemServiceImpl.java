package com.example.products.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.products.domain.OrderItem;
import com.example.products.domain.Orders;
import com.example.products.domain.Product;
import com.example.products.domain.User;
import com.example.products.repository.OrderItemRepository;
import com.example.products.repository.OrdersRepository;
import com.example.products.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrdersRepository ordersRepository;
	
	
	@Override
	public OrderItem save(OrderItem item, Product prod) {
		OrderItem orderItem = new OrderItem();
		orderItem.setProduct(prod);
		orderItem.setQuantity(item.getQuantity());
		orderItemRepository.save(orderItem);
		
		Orders order = ordersRepository.getOne(1l);
		order.getOrderItems().add(orderItem);
		ordersRepository.save(order);

		return orderItem;
	}

	@Override
	public OrderItem delete(Long id) {
		
		OrderItem orderItem = orderItemRepository.getOne(id);
		
		if(orderItem == null) {
			throw new IllegalArgumentException("Tried to delete" + "non-existant item");
		}
		else {
			orderItemRepository.delete(orderItem);
		}
		
		return orderItem;
	}

}
