package com.tejovat.starmart.dto;

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
	private Boolean active;
	private String username;

}
