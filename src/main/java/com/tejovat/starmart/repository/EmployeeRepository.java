package com.tejovat.starmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejovat.starmart.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
