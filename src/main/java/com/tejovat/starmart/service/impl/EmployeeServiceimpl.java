package com.tejovat.starmart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejovat.starmart.model.Employee;
import com.tejovat.starmart.repository.EmployeeRepository;
import com.tejovat.starmart.service.EmployeeService;

@Service
public class EmployeeServiceimpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getEmployeeList() {
		return empRepo.findAll();
	}

}
