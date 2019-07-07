package com.hostal.springboot.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hostal.springboot.app.model.Habitacion;
@Repository
public interface HabitacionRepository extends PagingAndSortingRepository<Habitacion, Integer> {

}
