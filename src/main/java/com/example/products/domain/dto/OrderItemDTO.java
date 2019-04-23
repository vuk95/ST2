package com.example.products.domain.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.products.domain.Product;

public class OrderItemDTO {

	Product product;
	@NotNull
	@Min(1)
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
