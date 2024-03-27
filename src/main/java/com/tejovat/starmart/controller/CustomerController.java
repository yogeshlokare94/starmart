package com.tejovat.starmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.starmart.dto.CustomerDto;
import com.tejovat.starmart.dto.LoginForm;
import com.tejovat.starmart.model.Customer;
import com.tejovat.starmart.service.CustomerService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllCustomers(){
		List<CustomerDto> list = customerService.getAllCustomers();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable("id") Long id){
		Customer customer  = customerService.getCustomerById(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<?> createCustomer(@RequestBody @Valid Customer customer) {
		Customer newCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> createCustomer(@RequestBody LoginForm loginForm) {
		Customer customer = customerService.getCustomerByUsername(loginForm.getUsername());
		if(customer !=null) {
			if(customer.getPassword().equals(loginForm.getPassword())){
				return new ResponseEntity<>("Login Success", HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>("Login Failed", HttpStatus.UNAUTHORIZED);
			}
		}else {
			return new ResponseEntity<>("User Not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
		Customer updatedCustomer = customerService.updateCustomer(id, customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id){
		return new ResponseEntity<>(customerService.deleteCustomerById(id), HttpStatus.OK);
	}
	
	@GetMapping("/city")
	public ResponseEntity<?> getCustomersByCity(@RequestParam(name="cityName") String cityName){
		List<Customer> customer  = customerService.getCustomerByCityName(cityName);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
}
