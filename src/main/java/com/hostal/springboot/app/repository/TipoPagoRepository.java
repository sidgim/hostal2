package com.hostal.springboot.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hostal.springboot.app.model.TipoPago;

public interface TipoPagoRepository extends PagingAndSortingRepository<TipoPago, Integer> {

}
