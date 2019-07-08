package com.hostal.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import com.hostal.springboot.app.commons.GenericServiceImp;
import com.hostal.springboot.app.model.Usuario;
import com.hostal.springboot.app.repository.UsuarioRepository;

@Service
public class UsuariosServiceImp extends GenericServiceImp<Usuario, Integer>implements UsuariosService{
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Override
	public PagingAndSortingRepository<Usuario, Integer> getRepository() {
		return usuarioRepository;
	}

}
