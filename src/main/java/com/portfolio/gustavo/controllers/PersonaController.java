package com.portfolio.gustavo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.gustavo.models.PersonaModel;
import com.portfolio.gustavo.models.User;
import com.portfolio.gustavo.services.PersonaService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/persona")
public class PersonaController {
	@Autowired
	PersonaService personaService;

	// @Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping()
	public ArrayList<PersonaModel> obtenerPersonas(){
		return personaService.obtenerPersonas();
	}
	
	@PostMapping()
	public PersonaModel guardarPersona(@RequestBody PersonaModel persona) {
		return this.personaService.guardarPersona(persona);
	}
	
	@GetMapping("/id")
	@ResponseBody
	public Optional<PersonaModel> obtenerPersonaId(@RequestParam Long id_persona){
		return personaService.obtenerPersonaId(id_persona);
	}
	
	@PutMapping("/actualizar")
	public PersonaModel actualizarPersona(@RequestBody PersonaModel persona) {
		return this.personaService.actualizarPersona(persona);
	}
	
	
	@GetMapping("/prueba")
	@ResponseBody
	public String getFoos(@RequestParam(required = false) String id) { 
	    return "ID: " + id;
	}

}
