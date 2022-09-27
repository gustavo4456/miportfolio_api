package com.portfolio.gustavo.controllers;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.gustavo.models.Authority;
import com.portfolio.gustavo.models.User;
import com.portfolio.gustavo.services.AuthorityService;
import com.portfolio.gustavo.services.UsuarioService;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AuthorityService authorityService;
	
	//USUARIO
	//PARA LA TABLA USUARIO

	@GetMapping({"/gestion_usuario"})
	public String verUsuario(Model model) {
		
		model.addAttribute("usuario", new User());
		model.addAttribute("listaUsuario", usuarioService.obtenerUsuarios());
		model.addAttribute("autoridades", authorityService.obtenerTodasAutoridades());
		
		return "usuarios/gestion_usuario";
	}



	@PostMapping({"/guardar"})
	public String crearUsuario(Model modelo, User usuario) {
		usuarioService.guardarUsuario(usuario);
		
		modelo.addAttribute("usuario", new User());
		modelo.addAttribute("listaUsuario", usuarioService.obtenerUsuarios());
		modelo.addAttribute("autoridades", authorityService.obtenerTodasAutoridades());
		return "redirect:/gestion_usuario";
	}

	@GetMapping({"/editarUsuario/{id}"})
	public String editarUsuarioForm(Model modelo, @PathVariable(name="id") Long id) {
		User usuarioParaEditar = usuarioService.obtenerUserId(id).orElse(null);
		modelo.addAttribute("usuario",usuarioParaEditar);
		modelo.addAttribute("listaUsuario",usuarioService.obtenerUsuarios());//SELECT * FROM USUARIOS;
		modelo.addAttribute("autoridades",authorityService.obtenerTodasAutoridades());
		return "usuarios/gestion_usuario";
	}
	
	@GetMapping({"/eliminarUsuario/{id}"})
	public String eliminarUsuario(Model modelo, @PathVariable(name="id") Long id) {
		User usuarioParaEliminar = usuarioService.obtenerUserId(id).orElse(null);
		usuarioService.eliminarUsuario(usuarioParaEliminar.getId());
		modelo.addAttribute("usuario",new User());
		modelo.addAttribute("listaUsuario",usuarioService.obtenerUsuarios());//SELECT * FROM USUARIOS;
		modelo.addAttribute("autoridades",authorityService.obtenerTodasAutoridades());
		return "redirect:/gestion_usuario";
	}
	
	
	
}
