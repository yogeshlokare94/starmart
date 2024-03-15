package com.tejovat.starmart.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.starmart.model.Customer;
import com.tejovat.starmart.service.CustomerService;


@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") Long id) {
		return customerService.getCustomerById(id);
	}
	
	@PostMapping("")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
	
	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteCustomer(@PathVariable("id") Long id){
		return customerService.deleteCustomerById(id);
	}
}
