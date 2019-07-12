package com.hostal.springboot.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hostal.springboot.app.model.Temporada;
import com.hostal.springboot.app.services.TemporadaService;

@Controller
public class TemporadaController {

	@Autowired
	private TemporadaService temporadaService;
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/temporada")
	public String habitacion( Model model ) {
 		model.addAttribute("listTemporada", temporadaService.getAll());
		return "temporada";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/formulario-temporada/{id}")
	public String Showsave(@PathVariable ("id") Integer id, Model model) {

		if (id != null && id != 0) {
			model.addAttribute("temporada" , temporadaService.get(id));
		}else {
			model.addAttribute("temporada", new Temporada());
		}
		return "formulario-temporada";
	}
	
	@Secured("ROLE_USER")
	@PostMapping("/formulario-temporada")
	public String save (@Valid Temporada temporada ,BindingResult result, Model model,RedirectAttributes flash ) {
		if(result.hasErrors()) {
			return "redirect:/formulario-temporada/0";
		}
		flash.addFlashAttribute("success", "Se ha agregado con éxito una temporada");
		temporadaService.save(temporada);	
		return "redirect:/temporada";
	}
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete2/{id}")
	public String delete (@PathVariable Integer id , Model model) {
		temporadaService.delete(id);
			return "redirect:/temporada";
	}
}
