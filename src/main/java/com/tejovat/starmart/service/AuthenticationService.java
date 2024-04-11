package com.tejovat.starmart.service;

import com.tejovat.starmart.dto.LoginUserDto;
import com.tejovat.starmart.dto.RegisterUserDto;
import com.tejovat.starmart.model.User;

public interface AuthenticationService {
	
	public User signup(RegisterUserDto registerUserDto);
	
	public User authenticate(LoginUserDto loginUserDto);

}
