package com.hostal.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.Servicio;
import com.hostal.springboot.app.repository.ServicioRepository;
@Service
public class ServicioServiceImp extends GenericServiceImp<Servicio, Integer> implements ServicioService{
	@Autowired
	private ServicioRepository servicioRepository;
	@Override
	public CrudRepository<Servicio, Integer> getRepository() {
		return servicioRepository;
	}

}
