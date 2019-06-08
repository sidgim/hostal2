package com.hostal.springboot.app.controller;

import org.hibernate.boot.model.relational.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	@Autowired
	private HabitacionService habitacionService;
	@Autowired
	private TemporadaService temporadaService;
	@Autowired
	private ReservaService reservaService;
	
	@RequestMapping("/")
	public String habitacion(Model model) {
		model.addAttribute("list", habitacionService.getAll());
		return "index";
	}
	@RequestMapping("/reserva")
	public String reserva(Model model) {
		model.addAttribute("habitaciones", habitacionService.getAll());
		model.addAttribute("list", reservaService.getAll());
		return "reserva";
	}
	
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
	
	@PostMapping(value = "/save")
	public String save (Habitacion habitacion, Model model , @RequestParam(value = "temporadaId", required = true) int temp) {
		Temporada t = temporadaService.get(temp);
		habitacion.setTemporada(t);
		habitacionService.save(habitacion);	
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String delete (@PathVariable Integer id , Model model) {
		habitacionService.delete(id);
			return "redirect:/";
	}
	
	@RequestMapping("/acercade")
	public String servicio(Model model) {
		return "acercade";
	}
	
}
