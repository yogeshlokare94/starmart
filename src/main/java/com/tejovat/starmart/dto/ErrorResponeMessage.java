package com.tejovat.starmart.dto;

import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponeMessage {
	
	private Integer statusCode;
	private Date timestamp;
	private String message;
	private Map<String, String> errorList;
}
