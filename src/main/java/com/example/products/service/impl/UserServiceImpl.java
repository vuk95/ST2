package com.example.products.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.products.domain.User;
import com.example.products.repository.UserRepository;
import com.example.products.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;;
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
