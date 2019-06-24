package com.hostal.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostal.springboot.app.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

	public Usuario findByUsername(String username);
}
