package com.hostal.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.Temporada;
import com.hostal.springboot.app.repository.TemporadaRepository;
@Service
public class TemporadaServiceImp extends GenericServiceImp<Temporada,Integer> implements TemporadaService{
	@Autowired
	private TemporadaRepository temporadaRepository;
	@Override
	public PagingAndSortingRepository<Temporada, Integer> getRepository() {
		return temporadaRepository;
	}

}
