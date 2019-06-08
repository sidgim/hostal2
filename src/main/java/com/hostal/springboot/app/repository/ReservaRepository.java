package com.hostal.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostal.springboot.app.model.Reserva;

public interface ReservaRepository extends CrudRepository<Reserva, Long> {

}
