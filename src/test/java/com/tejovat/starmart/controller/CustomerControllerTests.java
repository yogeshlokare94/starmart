package com.tejovat.starmart.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tejovat.starmart.dto.CustomerDto;
import com.tejovat.starmart.service.CustomerService;

@SpringBootTest
public class CustomerControllerTests {
	
	@InjectMocks
	CustomerController customerController;
	
	@Mock
	CustomerService customerService;
	
	@Test
	public void testGetAllCustomers() {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(1L);
		customerDto.setFirstName("Yogesh");
		List<CustomerDto> list = Arrays.asList(customerDto);
		when(customerService.getAllCustomers()).thenReturn(list);
		ResponseEntity<?> response = customerController.getAllCustomers();
		assertNotNull(response);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

}
