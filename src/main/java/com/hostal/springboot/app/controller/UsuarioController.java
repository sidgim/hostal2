package com.hostal.springboot.app.controller;

import java.lang.reflect.Method;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.type.classreading.MethodsMetadataReader;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hostal.springboot.app.model.Usuario;
import com.hostal.springboot.app.services.UsuariosService;
import com.hostal.springboot.app.util.paginator.PageRender;

@SpringBootApplication
@Controller
public class UsuarioController {
	@Autowired
	private UsuariosService usuarioService;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Secured("ROLE_ADMIN")
	@RequestMapping("/usuario")
	public String usuario(@RequestParam(name="page", defaultValue = "0") int page,Model model) {
		Pageable pageRequest = PageRequest.of(page,100); 
		Page<Usuario> pagina = usuarioService.getAll(pageRequest);
		PageRender<Usuario> pageRender = new PageRender<>("/usuario",pagina);
		model.addAttribute("listUsuario",pagina);
 		model.addAttribute("page",pageRender);
		return "usuario";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/formulario-usuario/{id}")
	public String Showsave(@PathVariable ("id") Integer id, Model model) {

		if (id != null && id != 0) {
			model.addAttribute("usuario" , usuarioService.get(id));
		}else {
			model.addAttribute("usuario", new Usuario());
		}
		return "formulario-usuario";
	}
	
	@Secured("ROLE_ADMIN")
	@PostMapping("/formulario-usuario")
	public String save (@Valid Usuario usuario,BindingResult result, Model model , 
			@RequestParam(defaultValue  = "id") String temp) {
		if(result.hasErrors()) {
			return "redirect:/formulario-usuario/0";
		}
			
			String bcryptPassword = passwordEncoder.encode(temp);
			usuario.setPassword(bcryptPassword);
			System.out.println(usuario);

		usuarioService.save(usuario);
		return "redirect:/usuario";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/DeleteUsuario/{id}")
	public String delete (@PathVariable Integer id , Model model) {
			usuarioService.delete(id);
			return "redirect:/usuario";
	}
}
