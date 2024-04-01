package com.tejovat.starmart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejovat.starmart.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("")
	public ResponseEntity<?> getAllRoles(){
		return new ResponseEntity<>(roleService.getRoleList(), HttpStatus.OK);
	}

}

