package com.hostal.springboot.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.ReservaHabitacion;
import com.hostal.springboot.app.repository.ReservaHabitacionRepository;


@Service
public class  ReservaHabitacionServiceImp extends GenericServiceImp<ReservaHabitacion, Integer> implements ReservaHabitacionService {
	@Autowired
	private ReservaHabitacionRepository reservaHabitacionRepository;
	@Override
	public CrudRepository<ReservaHabitacion, Integer> getRepository() {
		return reservaHabitacionRepository;
	}


 

	
}
