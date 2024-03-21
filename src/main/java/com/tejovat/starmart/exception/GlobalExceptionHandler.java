package com.tejovat.starmart.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tejovat.starmart.dto.ErrorResponeMessage;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoCustomerFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public ResponseEntity<?> noCustomerFoundExcpetion(NoCustomerFoundException ex){
		ErrorResponeMessage errorResponeMessage = new ErrorResponeMessage(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), null);
		return new ResponseEntity<>(errorResponeMessage, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
		Map<String, String> erroList = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			erroList.put(fieldName, error.getDefaultMessage());
		});
		ErrorResponeMessage errorResponeMessage = new ErrorResponeMessage(HttpStatus.BAD_REQUEST.value(), new Date(), null, erroList);
		return new ResponseEntity<>(errorResponeMessage, HttpStatus.BAD_REQUEST);
	}

}
