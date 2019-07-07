package com.hostal.springboot.app.repository;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.hostal.springboot.app.model.Huesped;

public interface HuespedRepository extends PagingAndSortingRepository<Huesped, Integer>{

}
