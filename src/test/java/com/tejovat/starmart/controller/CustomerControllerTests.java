package com.tejovat.starmart.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tejovat.starmart.dto.CustomerDto;
import com.tejovat.starmart.exception.NoCustomerFoundException;
import com.tejovat.starmart.model.Address;
import com.tejovat.starmart.model.Customer;
import com.tejovat.starmart.service.CustomerService;

@SpringBootTest
public class CustomerControllerTests {

	@InjectMocks
	CustomerController customerController;

	@Mock
	CustomerService customerService;

	@Test
	void testGetAllCustomers() {
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

	@Test
	void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("Narsimha");
		customer.setContactNo("9874563215");
		customer.setLastName("Garu");
		customer.setEmail("yogeshlokre7@gmail.com");
		customer.setAddress(new Address(1l, 1, "Hello", null, null, null));
		when(customerService.createCustomer(any())).thenReturn(customer);
		ResponseEntity<Customer> response = customerController.createCustomer(customer);
		assertNotNull(response);
		assertNotNull(response.getBody());
		assertSame("Narsimha", response.getBody().getFirstName());
	}

	@Test
	void getCustomerByIdTest() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setFirstName("Narsimha");
		when(customerService.getCustomerById(anyLong())).thenReturn(customer);
		ResponseEntity<Customer> customer1 = customerController.getCustomerById(1L);
		assertNotNull(customer1);

		when(customerService.getCustomerById(anyLong())).thenThrow(new NoCustomerFoundException("Customer Not found"));
		assertThrows(NoCustomerFoundException.class, ()-> customerService.getCustomerById(124L));
		assertThrows(NoCustomerFoundException.class, ()-> customerService.getCustomerById(125L));
	}


}
