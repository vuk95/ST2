package com.example.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.products.domain.OrderItem;
import com.example.products.domain.Product;
import com.example.products.domain.dto.OrderItemDTO;
import com.example.products.domain.dto.ProductDTO;
import com.example.products.mapper.OrderItemMapper;
import com.example.products.mapper.ProductMapper;
import com.example.products.service.OrderItemService;
import com.example.products.service.ProductsService;


@RestController
public class ProductsController {
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private OrderItemMapper orderItemMapper;
	
	@RequestMapping(value = "/product/add", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> addProduct(@RequestBody ProductDTO prodDTO){
		
		productsService.save(productMapper.ProductDTOtoProduct(prodDTO));
		
		return new ResponseEntity<>(prodDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> getProducts() {
		
		List<Product> products = productsService.findAll();
	
		return new ResponseEntity<>(productMapper.productsToProductsDTO(products), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
		
		Product product = productsService.findOne(id);
		
		return new ResponseEntity<>(productMapper.ProductToProductDTO(product), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/item/add/{id}", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> addOrderItem(@Validated @RequestBody OrderItemDTO itemDTO, @PathVariable Long id, Errors errors){
		
		if(errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
		}
		
		Product prod = productsService.findOne(id);
		OrderItem created = orderItemService.save(orderItemMapper.OrderItemDTOtoOrderItem(itemDTO), prod);
		
		return new ResponseEntity<>(orderItemMapper.OrderItemToOrderItemDTO(created), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/item/delete/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteOrderItem(@PathVariable Long id){
		
		OrderItem deleted = orderItemService.delete(id);
		
		return new ResponseEntity<>(orderItemMapper.OrderItemToOrderItemDTO(deleted), HttpStatus.OK);
	}

}
