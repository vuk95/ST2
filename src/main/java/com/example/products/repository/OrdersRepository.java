package com.example.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.products.domain.Orders;
import com.example.products.domain.User;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{
	
	Orders findByEmail(String email);

}
