package com.hostal.springboot.app.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hostal.springboot.app.model.Habitacion;
import com.hostal.springboot.app.model.Huesped;
import com.hostal.springboot.app.model.Reserva;
import com.hostal.springboot.app.model.TipoPago;
import com.hostal.springboot.app.services.HabitacionService;
import com.hostal.springboot.app.services.HuespedService;
import com.hostal.springboot.app.services.ReservaService;
import com.hostal.springboot.app.services.TipoPagoService;
import com.hostal.springboot.app.util.paginator.PageRender;


@Controller

public class ReservaController {
	@Autowired
	private ReservaService reservaService;
	@Autowired
	private HabitacionService habitacionService;
	@Autowired
	private TipoPagoService tipoPagoService;
	@Autowired
	private HuespedService huespedService;

	@Secured("ROLE_USER")
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Reserva> lista = reservaService.getAll();
		if(!lista.isEmpty())
		this.InOrderF(lista);
		model.addAttribute("list", lista);
		return "reservalist";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping("/verReservas")
	public String reserva(@RequestParam(name="page", defaultValue = "0") int page,Model model) {
		Pageable pageRequest = PageRequest.of(page,100); 
		Page<Reserva> pagina = reservaService.getAll(pageRequest);
		PageRender<Reserva> pageRender = new PageRender<>("/verReservas",pagina);
		model.addAttribute("habitaciones", habitacionService.getAll());
		model.addAttribute("listR",  pagina);
		model.addAttribute("page",pageRender);
		return "verReservas";
	}
	
	@Secured("ROLE_USER")
	@GetMapping(value = "/reserva/{id}")
	public String Showsave(@PathVariable("id") Integer id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("reservas" , reservaService.get(id));
			model.addAttribute("habitacion" , habitacionService.getAll());
			model.addAttribute("tipoP", tipoPagoService.getAll());
			model.addAttribute("huespedes", huespedService.getAll());
		
		}else {
			model.addAttribute("reservas", new Reserva());
			model.addAttribute("habitacion" , habitacionService.getAll());
			model.addAttribute("tipoP", tipoPagoService.getAll());
			model.addAttribute("huespedes", huespedService.getAll());
		
		}
		return "reserva";
	}
	
	@Secured("ROLE_USER")
	@PostMapping(value = "/reserva")
	public String save (@Valid Reserva reserva,BindingResult result, Model model, @RequestParam(value = "HabitacionId", required = true) int re,
			@RequestParam(value = "HuespedId", required = true) int cli,@RequestParam(value = "tipoPagoId", required = true) int tip
			,RedirectAttributes flash) {
		if(result.hasErrors()) {
			flash.addFlashAttribute("error", "favor de ingresar correctamente los datos");
			return "redirect:/reserva/0";
		}
		Habitacion h = habitacionService.get(re);
		Huesped hu = huespedService.get(cli);
		TipoPago t = tipoPagoService.get(tip);
		reserva.setHuesped(hu);
		reserva.setTipoPago(t);
		reserva.setHabitacion(h);
		reservaService.save(reserva);
		flash.addFlashAttribute("success", "Se ha agregado con éxito la reserva");

		return "redirect:/verReservas";
		
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/deletes/{id}")
	public String delete (@PathVariable Integer id , Model model) {
			reservaService.delete(id);blob:https://web.whatsapp.com/5adaa5ee-88ea-4e1c-af3b-2cd042cb4e87
			return "redirect:/verReservas";
	}
	
	private void InOrderF(List<Reserva> list){
        Collections.sort(list, new Comparator<Reserva>() {
            @Override
            public int compare(Reserva o1, Reserva o2) {
                return o1.getFechaEntrada().compareTo(o2.getFechaEntrada());
            }
        });
	}

}