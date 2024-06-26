package com.tejovat.starmart.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tejovat.starmart.dto.CustomerDto;
import com.tejovat.starmart.exception.NoCustomerFoundException;
import com.tejovat.starmart.model.Customer;
import com.tejovat.starmart.repository.CustomerRepository;
import com.tejovat.starmart.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	
	CustomerServiceImpl(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<CustomerDto> customerDtoList = customerRepository.findAll().stream().
				map(customer -> convertCustomerEntityToDto(customer)).collect(Collectors.toList());
		return customerDtoList;
	}

	@Override
	public Customer getCustomerById(Long id){
		return customerRepository.findById(id).orElseThrow(() -> new NoCustomerFoundException("Customer not found with this Id: "+id));
	}
	
	//Create/Save Customer
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	//Edit/Update Customer
	@Override
	public Customer updateCustomer(Long id, Customer customer){
		Customer existingCustomer  = getCustomerById(id);
		if(existingCustomer != null) {
			existingCustomer.setFirstName(customer.getFirstName());
			existingCustomer.setLastName(customer.getLastName());
			existingCustomer.setEmail(customer.getEmail());
			existingCustomer.setUsername(customer.getUsername());
			existingCustomer.setContactNo(customer.getContactNo());
			existingCustomer.setActive(customer.getActive());
			return customerRepository.save(existingCustomer);
		}
		return existingCustomer;
	}
	
	//Delete customer By Id
	@Override
	public Map<String, Boolean> deleteCustomerById(Long id){
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
	
	
	public CustomerDto convertCustomerEntityToDto(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setContactNo(customer.getContactNo());
		customerDto.setUsername(customer.getUsername());
		customerDto.setActive(customer.getActive());
//		customerDto.setAddress(customer.getAddress());
		return customerDto;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		List<Customer> list = customerRepository.findByUsername(username);
		if(list != null  && list.size() > 0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<Customer> getCustomerByCityName(String cityName) {
		return customerRepository.getCustomerListByCityName(cityName);
	}

	@Override
	public List<Customer> getEntityList() {
		return customerRepository.findAll();
	}
}
