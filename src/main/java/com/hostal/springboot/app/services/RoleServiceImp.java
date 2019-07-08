package com.hostal.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.Role;
import com.hostal.springboot.app.repository.RoleRepository;
@Service
public class RoleServiceImp extends GenericServiceImp<Role, Integer> implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public PagingAndSortingRepository<Role, Integer> getRepository() {
		return roleRepository;
	}

}
