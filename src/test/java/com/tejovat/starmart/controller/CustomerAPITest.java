package com.tejovat.starmart.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.tejovat.starmart.dto.CustomerDto;
import com.tejovat.starmart.service.CustomerService;

@WebMvcTest(CustomerController.class)
public class CustomerAPITest {

	@MockBean
	CustomerService customerService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void testGetAllCustomers() throws Exception {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(1L);
		customerDto.setFirstName("Yogesh");
		List<CustomerDto> list = Arrays.asList(customerDto);

		when(customerService.getAllCustomers()).thenReturn(list);

		mockMvc.perform(get("/customers")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].firstName", Matchers.is("Yogesh")));
	}

}
