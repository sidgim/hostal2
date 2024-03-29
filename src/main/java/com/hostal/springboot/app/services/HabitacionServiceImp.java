package com.hostal.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.Habitacion;
import com.hostal.springboot.app.repository.HabitacionRepository;

@Service
public class HabitacionServiceImp extends GenericServiceImp<Habitacion, Integer> implements HabitacionService{
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Override
	public PagingAndSortingRepository<Habitacion, Integer> getRepository() {
		return habitacionRepository;
	}

}
