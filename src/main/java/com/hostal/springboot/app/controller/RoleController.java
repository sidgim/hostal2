package com.hostal.springboot.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hostal.springboot.app.model.Habitacion;
import com.hostal.springboot.app.model.Role;
import com.hostal.springboot.app.model.Usuario;
import com.hostal.springboot.app.services.RoleService;
import com.hostal.springboot.app.services.UsuariosService;
import com.hostal.springboot.app.util.paginator.PageRender;

@Controller
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UsuariosService usuarioService;
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/usuarios")
	public String habitacion( Model model ) {
 		model.addAttribute("listRole", roleService.getAll());
		return "usuario";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping(value = "/role/{id}")
	public String Showsave(@PathVariable("id") Integer id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("role" , roleService.get(id));
			model.addAttribute("usuario" , usuarioService.getAll());

		}else {
			model.addAttribute("role", new Role());
			model.addAttribute("usuario" , usuarioService.getAll());

		}
		return "role";
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/role")
	public String save (@Valid Role role,BindingResult result, Model model , 
			@RequestParam(value  = "id",required = true) Integer temp) {
		if(result.hasErrors()) {
			return "redirect:/role/0";
		}
		
		Usuario u = usuarioService.get(temp);
		
		role.setUsuario(u);
		roleService.save(role);
		return "redirect:/usuario";
	}
		
}
