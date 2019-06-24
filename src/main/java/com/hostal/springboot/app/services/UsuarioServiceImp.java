package com.hostal.springboot.app.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostal.springboot.app.model.Role;
import com.hostal.springboot.app.model.Usuario;
import com.hostal.springboot.app.repository.UsuarioRepository;

@Service("usuarioServiceImp")
public class UsuarioServiceImp implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImp.class);
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		
		if(usuario==null) {
			logger.error("Error login: no existe el usuario'"+ username+"'");
			throw new UsernameNotFoundException("Username"+ username+ "no exixste en el sistema");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(Role role: usuario.getRoles()) {
			logger.info("Role :".concat(role.getAuthority()));
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		
		if(authorities.isEmpty()) {
			logger.error("Error login: no existe el usuario'"+ username+"' no tiene roles asignado");
			throw new UsernameNotFoundException("Error login: no existe el usuario'"+ username+"' no tiene roles asignado");
		}
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnable(), true, true, true, authorities);
	}

}
