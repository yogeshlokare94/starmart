package com.tejovat.starmart.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejovat.starmart.model.Customer;
import com.tejovat.starmart.repository.CustomerRepository;
import com.tejovat.starmart.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id){
		return customerRepository.findById(id).orElse(null);
	}
	
	//Create/Save Customer
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	//Edit/Update Customer
	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		Customer existingCustomer  = getCustomerById(id);
		if(existingCustomer != null) {
			existingCustomer.setFirstName(customer.getFirstName());
			existingCustomer.setLastName(customer.getLastName());
			existingCustomer.setUsername(customer.getUsername());
			existingCustomer.setActive(customer.getActive());
			return customerRepository.save(existingCustomer);
		}
		return existingCustomer;
	}
	
	//Delete customer By Id
	@Override
	public Map<String, Boolean> deleteCustomerById(Long id) {
		Map<String, Boolean> map = new HashMap<>();
		Customer existingCustomer  = getCustomerById(id);
		if(existingCustomer != null) {
			customerRepository.delete(existingCustomer);
			map.put("deleted", Boolean.TRUE);
		}else {
			map.put("deleted", Boolean.FALSE);
		}
		return map;
	}
}
