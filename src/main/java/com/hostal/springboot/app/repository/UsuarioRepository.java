package com.hostal.springboot.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.hostal.springboot.app.model.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer>{

	public Usuario findByUsername(String username);
}
