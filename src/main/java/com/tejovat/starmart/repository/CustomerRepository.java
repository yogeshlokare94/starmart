package com.tejovat.starmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejovat.starmart.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	List<Customer> findByUsername(String username);

}
