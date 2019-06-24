package com.hostal.springboot.app.controller;

import java.util.Collection;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.hibernate.boot.model.relational.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hostal.springboot.app.model.Habitacion;
import com.hostal.springboot.app.model.Temporada;
import com.hostal.springboot.app.services.HabitacionService;
import com.hostal.springboot.app.services.ReservaService;
import com.hostal.springboot.app.services.TemporadaService;

@Controller
public class HabitacionController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private HabitacionService habitacionService;
	@Autowired
	private TemporadaService temporadaService;
	
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/index")
	public String habitacion(Model model ) {
		model.addAttribute("list", habitacionService.getAll());
		return "index";
	}

	@Secured("ROLE_ADMIN")
	@GetMapping(value = "/save/{id}")
	public String Showsave(@PathVariable("id") Integer id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("habitacion" , habitacionService.get(id));
			model.addAttribute("temporadas", temporadaService.getAll());

		}else {
			model.addAttribute("habitacion", new Habitacion());
			model.addAttribute("temporadas", temporadaService.getAll());
		}
		return "save";
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping(value = "/save")
	public String save (@Valid Habitacion habitacion,BindingResult result, Model model , @RequestParam(value = "temporadaId", required = true) Integer temp) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			logger.info("Usuario identificado: ".concat(auth.getName()));
		}
		
		if(hasRole("ROLE_ADMIN")) {
			logger.info("hola ".concat(auth.getName()).concat("Tienes acceso"));
		}else {
			logger.info("hola ".concat(auth.getName()).concat("No tienes acceso"));

		}
		
		if(result.hasErrors()) {
			return "redirect:/save";
		}
		Temporada t = temporadaService.get(temp);
		habitacion.setTemporada(t);
		habitacionService.save(habitacion);	
		return "redirect:/index";
		
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/delete/{id}")
	public String delete (@PathVariable Integer id , Model model) {
		habitacionService.delete(id);
			return "redirect:/index";
	}

	@RequestMapping("/acercade")
	public String servicio(Model model) {
		return "acercade";
	}
	
	
	@RequestMapping({"/catalogo","/"})
	public String habitaciones(Model model) {
		return "catalogo";
	}
	
	private boolean hasRole(String role) {
		
		SecurityContext context = SecurityContextHolder.getContext();
		if(context == null) {
			return false;
		}
		Authentication auth = context.getAuthentication();
		
		if(auth == null) {
			return false;
		}
		
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		
		for(GrantedAuthority authority: authorities) {
			if(role.equals(authority.getAuthority())) {
				return true;
			}
		}
		return false;
	}
}
