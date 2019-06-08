package com.hostal.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.Huesped;
import com.hostal.springboot.app.repository.HuespedRepository;

@Service
public class HuespedServiceImp extends GenericServiceImp<Huesped, Long> implements HuespedService {

	@Autowired
	private HuespedRepository huespedRepository;
	@Override
	public CrudRepository<Huesped, Long> getRepository() {
		return huespedRepository;
	}

}
