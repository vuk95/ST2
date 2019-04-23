package com.example.products.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.products.domain.Product;
import com.example.products.repository.ProductsRepository;
import com.example.products.service.ProductsService;

@Service
@CacheConfig(cacheNames={"products"})
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	private ProductsRepository productsRepository;

	
	@Override
	@CacheEvict(allEntries = true) 
	public void save(Product prod) {
		
		productsRepository.save(prod);
				
	}

	@Cacheable
	@Override
	public List<Product> findAll() {
		simulateSlowService();
		return productsRepository.findAll();
	}

	@Override
	public Product findOne(Long id) {
		
		return productsRepository.getOne(id);
	}
	
	//METHOD THAT SIMULATE SLOW SERVICE THIS SHOW USAGE OF CACHING
	private void simulateSlowService() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
