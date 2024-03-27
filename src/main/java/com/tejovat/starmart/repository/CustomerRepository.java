package com.tejovat.starmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tejovat.starmart.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	List<Customer> findByUsername(String username);
	
	@Query(value="select * from customer where id in (select customerId from Address where city=?1)", nativeQuery = true)
	List<Customer> getCustomerListByCityName(String cityName);
}
