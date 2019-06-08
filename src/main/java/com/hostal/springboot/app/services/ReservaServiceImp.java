package com.hostal.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.Reserva;
import com.hostal.springboot.app.repository.ReservaRepository;
@Service
public class ReservaServiceImp extends GenericServiceImp<Reserva, Integer> implements ReservaService {
	
	@Autowired	
	private ReservaRepository reservaRepository;
	
	@Override
	public CrudRepository<Reserva, Integer> getRepository() {

		return reservaRepository;
	}

}
