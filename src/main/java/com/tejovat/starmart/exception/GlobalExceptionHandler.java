package com.tejovat.starmart.exception;

import java.util.Collections;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tejovat.starmart.dto.ErrorResponeMessage;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoCustomerFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ResponseEntity<?> noCustomerFoundExcpetion(NoCustomerFoundException ex){
		ErrorResponeMessage errorResponeMessage = new ErrorResponeMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), Collections.emptyList());
		return new ResponseEntity<>(errorResponeMessage, HttpStatus.NOT_FOUND);
	}

}
