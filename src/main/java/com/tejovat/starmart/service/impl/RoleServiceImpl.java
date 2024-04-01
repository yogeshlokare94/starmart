package com.tejovat.starmart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejovat.starmart.model.Roles;
import com.tejovat.starmart.repository.RoleRepository;
import com.tejovat.starmart.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepo;

	@Override
	public List<Roles> getRoleList() {
		return roleRepo.findAll();
	}

}
