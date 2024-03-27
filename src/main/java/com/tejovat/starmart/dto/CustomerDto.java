package com.tejovat.starmart.dto;

import com.tejovat.starmart.model.Address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String contactNo;
	private Boolean active;
	private String username;
	private Address address;

}
