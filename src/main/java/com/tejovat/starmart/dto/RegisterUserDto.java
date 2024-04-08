package com.tejovat.starmart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterUserDto {
	
    private String email;
    
    private String password;
    
    private String fullName;
    
}