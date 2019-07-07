package com.hostal.springboot.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hostal.springboot.app.model.Reserva;

public interface ReservaRepository extends PagingAndSortingRepository<Reserva, Integer> {

}
