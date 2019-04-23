package com.example.products.service;

import com.example.products.domain.User;

public interface UserService {

	public User findByEmail(String email);
}
