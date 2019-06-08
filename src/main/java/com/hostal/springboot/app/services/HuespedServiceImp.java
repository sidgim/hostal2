package com.hostal.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.Huesped;
import com.hostal.springboot.app.repository.HuespedRepository;

@Service
public class HuespedServiceImp extends GenericServiceImp<Huesped, Integer> implements HuespedService {

	@Autowired
	private HuespedRepository huespedRepository;
	@Override
	public CrudRepository<Huesped, Integer> getRepository() {
		return huespedRepository;
	}

}
