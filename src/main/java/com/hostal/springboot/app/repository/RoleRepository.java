package com.hostal.springboot.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hostal.springboot.app.model.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Integer>{

}
