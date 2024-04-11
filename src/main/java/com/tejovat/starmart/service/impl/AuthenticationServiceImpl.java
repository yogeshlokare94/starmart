package com.tejovat.starmart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tejovat.starmart.dto.LoginUserDto;
import com.tejovat.starmart.dto.RegisterUserDto;
import com.tejovat.starmart.model.User;
import com.tejovat.starmart.repository.UserRepository;
import com.tejovat.starmart.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Autowired
	private UserRepository userRepository;  //field injection type - Type of Depedency Injection 
	
	@Autowired
	private PasswordEncoder encoder; //https://bcrypt-generator.com/#google_vignette
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
//	private UserRepository userRepository2;
//	
//	public AuthenticationServiceImpl(UserRepository userRepository2) {
//		this.userRepository2 = userRepository2
//	}
 
	@Override
	public User signup(RegisterUserDto registerUserDto) {
		User user = new User();
		user.setFullName(registerUserDto.getFullName());
		user.setEmail(registerUserDto.getEmail());
		user.setPassword(encoder.encode(registerUserDto.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User authenticate(LoginUserDto loginUserDto) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword()));
		return userRepository.findByEmail(loginUserDto.getEmail()).orElseThrow();
	}

}
