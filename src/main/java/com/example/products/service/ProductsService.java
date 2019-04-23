package com.example.products.service;

import java.util.List;

import com.example.products.domain.Product;

public interface ProductsService {
	
	public void save(Product p);
	
	public List<Product> findAll();
	
	public Product findOne(Long id);

}
