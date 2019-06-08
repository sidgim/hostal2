package com.hostal.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.ServicioHabitacion;
import com.hostal.springboot.app.repository.ServicioHabitacionRepository;
@Service
public class ServicioHabitacionServiceImp extends GenericServiceImp<ServicioHabitacion, Long> implements ServicioHabitacionService{
	@Autowired
	private ServicioHabitacionRepository servicioHabitacionRepository;
	@Override
	public CrudRepository<ServicioHabitacion, Long> getRepository() {
		return servicioHabitacionRepository;
	}

}
