package com.tejovat.starmart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejovat.starmart.model.User;
import com.tejovat.starmart.repository.UserRepository;
import com.tejovat.starmart.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> allUsers() {
		return userRepository.findAll();
	}

}
