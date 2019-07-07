package com.hostal.springboot.app.commons;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

}
