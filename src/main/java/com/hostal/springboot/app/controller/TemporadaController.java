package com.hostal.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hostal.springboot.app.model.Habitacion;
import com.hostal.springboot.app.model.Temporada;
import com.hostal.springboot.app.services.HabitacionService;
import com.hostal.springboot.app.services.TemporadaService;

@Controller
public class TemporadaController {
	@Autowired
	private TemporadaService temporadaService;
	@Autowired
	private HabitacionService habitacionService;
	/*
	
	@RequestMapping("/")
	public String temporada(Model model) {
		model.addAttribute("list", temporadaService.getAll());
		return "index";
	}
	@GetMapping("/save/{id}")
	public String Showsave(@PathVariable ("id") Integer id, Model model) {

		if (id != null && id != 0) {
			model.addAttribute("temporada" , temporadaService.get(id));
		}else {
			model.addAttribute("temporada", new Temporada());
		}
		return "save";
	}
	@PostMapping("/save")
	public String save (Temporada temporada, Model model) {
		temporadaService.save(temporada);	
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete (@PathVariable Integer id , Model model) {
		temporadaService.delete(id);
			return "redirect:/";
	}*/

}
