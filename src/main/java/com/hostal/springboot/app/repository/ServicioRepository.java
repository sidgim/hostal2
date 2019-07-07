package com.hostal.springboot.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hostal.springboot.app.model.Servicio;

public interface ServicioRepository extends PagingAndSortingRepository<Servicio, Integer> {

}
