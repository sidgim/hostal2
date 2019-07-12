package com.hostal.springboot.app.commons;

import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hostal.springboot.app.model.Huesped;
import com.hostal.springboot.app.model.Reserva;

public interface GenericService <T , ID extends Serializable> {
	
	//metodo de guardar 
	T save (T entity);
	//metodo de borrar
	void delete (ID id);
	//metodo de obtener por el id
	T get (ID id);
	//metodo de listar todo
	List<T> getAll();
	//metodo para paginar
		Page<T> getAll(Pageable pageable);
		//CreatePdf	
		boolean createPdf(List<Huesped> huespedes, ServletContext context, HttpServletResponse response);
		boolean createPdfReserva(List<Reserva> reservas, ServletContext context, HttpServletResponse response);
}
