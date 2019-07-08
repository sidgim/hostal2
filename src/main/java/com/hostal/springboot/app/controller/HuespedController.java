package com.hostal.springboot.app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hostal.springboot.app.model.Habitacion;
import com.hostal.springboot.app.model.Huesped;
import com.hostal.springboot.app.model.Reserva;
import com.hostal.springboot.app.model.Temporada;
import com.hostal.springboot.app.services.HabitacionService;
import com.hostal.springboot.app.services.HuespedService;
import com.hostal.springboot.app.services.TemporadaService;
import com.hostal.springboot.app.util.paginator.PageRender;

@Controller
public class HuespedController {
	@Autowired
	private HuespedService huespedService;
	
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/huesped")
	public String huesped(@RequestParam(name="page", defaultValue = "0") int page,Model model) {
		Pageable pageRequest = PageRequest.of(page,100); 
		Page<Huesped> pagina = huespedService.getAll(pageRequest);
		PageRender<Huesped> pageRender = new PageRender<>("/huesped",pagina);
		model.addAttribute("listHuesped",  pagina);
 		model.addAttribute("page",pageRender);

		return "huesped";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/formulario-huesped/{id}")
	public String Showsave(@PathVariable ("id") Integer id, Model model) {

		if (id != null && id != 0) {
			model.addAttribute("huesped" , huespedService.get(id));
		}else {
			model.addAttribute("huesped", new Huesped());
		}
		return "formulario-huesped";
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/formulario-huesped")
	public String save (@Valid Huesped huesped,BindingResult result, Model model ) {
		if(result.hasErrors()) {
			return "redirect:/formulario-huesped/0";
		}
		huespedService.save(huesped);	
		return "redirect:/huesped";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete1/{id}")
	public String delete (@PathVariable Integer id , Model model) {
		huespedService.delete(id);
			return "redirect:/huesped";
	}
	@RequestMapping("/huespedregister")
	public String servicio(Model model) {
		return "huespedregister";
	}
	
	@RequestMapping("/huespedreserva")
	public String reserva(Model model) {
		return "huespedreserva";
	}

}