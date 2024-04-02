package com.tejovat.starmart.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.tejovat.starmart.dto.CustomerDto;
import com.tejovat.starmart.exception.NoCustomerFoundException;
import com.tejovat.starmart.model.Customer;
import com.tejovat.starmart.repository.CustomerRepository;

@SpringBootTest
public class CustomerServiceImplTests {
	
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	@Mock
	private CustomerRepository customerRepository;

	
	@Disabled
	@Test
	public void getAllCustomersTest() {
		when(customerRepository.findAll()).thenReturn(Collections.emptyList());
		List<CustomerDto> customerList = customerService.getAllCustomers();
		assertNotNull(customerList);
		assertEquals(0, customerList.size());
	}
	
	@Test
	public void getCustomerByIdTest() {
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setFirstName("Narsimha");
		Optional<Customer> optCusotmer = Optional.ofNullable(customer);
		when(customerRepository.findById(anyLong())).thenReturn(optCusotmer);
		Customer customer1 = customerService.getCustomerById(1L);
		assertNotNull(customer1);
		
		when(customerRepository.findById(anyLong())).thenThrow(new NoCustomerFoundException("Customer Not found"));
		assertThrows(NoCustomerFoundException.class, ()-> customerService.getCustomerById(124L));
		assertThrows(NoCustomerFoundException.class, ()-> customerService.getCustomerById(125L));
	}

}
