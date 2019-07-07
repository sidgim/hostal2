package com.hostal.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.TipoPago;
import com.hostal.springboot.app.repository.TipoPagoRepository;
@Service
public class TipoPagoServiceImp extends GenericServiceImp<TipoPago, Integer>implements TipoPagoService{
	@Autowired
	private TipoPagoRepository tipoPagoRepository;
	@Override
	public PagingAndSortingRepository<TipoPago, Integer> getRepository() {
		return tipoPagoRepository;
	}

}
