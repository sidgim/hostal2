package com.hostal.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hostal.springboot.app.model.Reserva;
import com.hostal.springboot.app.services.ReservaService;

@Controller
public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;
	/*
	@RequestMapping("/indexs")
	public String reserva(Model model) {
		model.addAttribute("lista", reservaService.getAll());
		return "reserva";
	}
	@GetMapping("/savae/{id}")
	public String Showsave(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("reserva" , reservaService.get(id));
		}else {
			model.addAttribute("reserva", new Reserva());
		}
		return "save";
	}
	@PostMapping("/savae/)
	public String save (Reserva reserva, Model model) {
		reservaService.save(reserva);	
		return "redirect:/";
		
	}
	
	@DeleteMapping("/deletea/{id}")
	public String delete (@PathVariable Long id , Model model) {
			reservaService.delete(id);
			return "redirect:/";
	}*/
	@RequestMapping("/listreserva")
	public String reserva(Model model) {
		model.addAttribute("list", reservaService.getAll());
		return "listreserva";
	}
	
}
