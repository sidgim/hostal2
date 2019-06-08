package com.hostal.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.ReservaHuesped;
import com.hostal.springboot.app.repository.ReservaHuespedRepository;
@Service
public class ReservaHuespedServiceImp extends GenericServiceImp<ReservaHuesped, Long> implements ReservaHuespedService{
	@Autowired
	private ReservaHuespedRepository reservaHuespedRepository; 
	@Override
	public CrudRepository<ReservaHuesped, Long> getRepository() {
		return reservaHuespedRepository;
	}

}
