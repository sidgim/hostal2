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
import com.hostal.springboot.app.model.Huesped;
import com.hostal.springboot.app.model.Temporada;
import com.hostal.springboot.app.services.HabitacionService;
import com.hostal.springboot.app.services.HuespedService;
import com.hostal.springboot.app.services.TemporadaService;

@Controller
public class HuespedController {
	@Autowired
	private HuespedService huespedService;
	/*
	
	@RequestMapping("/formulario-cliente")
	public String huesped(Model model) {
		model.addAttribute("list", huespedService.getAll());
		return "reserva";
	}
	@GetMapping("/formulario-cliente/{id}")
	public String Showsave(@PathVariable ("id") Long id, Model model) {

		if (id != null && id != 0) {
			model.addAttribute("temporada" , huespedService.get(id));
		}else {
			model.addAttribute("temporada", new Huesped());
		}
		return "reserva";
	}
	@PostMapping("/formulario-cliente")
	public String save (Huesped huesped, Model model) {
		huespedService.save(huesped);	
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete (@PathVariable Long id , Model model) {
		huespedService.delete(id);
			return "redirect:/";
	}*/

}