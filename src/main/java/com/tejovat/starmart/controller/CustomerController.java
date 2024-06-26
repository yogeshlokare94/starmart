package com.tejovat.starmart.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tejovat.starmart.dto.CustomerDto;
import com.tejovat.starmart.dto.LoginForm;
import com.tejovat.starmart.model.Customer;
import com.tejovat.starmart.service.CustomerService;
import com.tejovat.starmart.service.EmailsService;

import jakarta.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	EmailsService emailsService;
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@GetMapping("")
	public ResponseEntity<List<CustomerDto>> getAllCustomers(){
		List<CustomerDto> list = customerService.getAllCustomers();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Customer>> getAllCustomerList(){
		List<Customer> list = customerService.getEntityList();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
		Customer customer  = customerService.getCustomerById(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Customer> createCustomer(@RequestBody @Valid Customer customer) {
		Customer newCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> createCustomer(@RequestBody LoginForm loginForm) {
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
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
		logger.info("Updating customer By Id {}", id);
		Customer updatedCustomer = customerService.updateCustomer(id, customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable("id") Long id){
		return new ResponseEntity<>(customerService.deleteCustomerById(id), HttpStatus.OK);
	}
	
	@GetMapping("/city")
	public ResponseEntity<?> getCustomersByCity(@RequestParam(name="cityName") String cityName){
		List<Customer> customer  = customerService.getCustomerByCityName(cityName);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
}
