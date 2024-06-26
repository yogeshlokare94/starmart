package com.tejovat.starmart.service;

import java.util.List;
import java.util.Map;

import com.tejovat.starmart.dto.CustomerDto;
import com.tejovat.starmart.model.Customer;

public interface CustomerService {
	
	public List<CustomerDto> getAllCustomers();
	
	public Customer getCustomerById(Long id);
	
	public Customer createCustomer(Customer customer);
	
	public Customer updateCustomer(Long id, Customer customer);
	
	public Map<String, Boolean> deleteCustomerById(Long id);

	public Customer getCustomerByUsername(String username);

	public List<Customer> getCustomerByCityName(String cityName);

	public List<Customer> getEntityList();

}
