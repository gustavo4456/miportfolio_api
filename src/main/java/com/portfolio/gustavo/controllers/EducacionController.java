package com.portfolio.gustavo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.portfolio.gustavo.models.EducacionModel;
import com.portfolio.gustavo.models.PersonaModel;
import com.portfolio.gustavo.services.EducacionService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/educacion")
public class EducacionController {
	@Autowired
	EducacionService educacionService;
	
	@GetMapping()
	public ArrayList<EducacionModel> obtenerEducacion(){
		return educacionService.obtenerEducacion();
	}
	
	@GetMapping("/por_id")
	@ResponseBody
	public ArrayList<EducacionModel> obtenerEducacionPorId(@RequestParam Long id_persona){
		return educacionService.obtenerEducacionPorId(id_persona);
	}
	
	@PostMapping()
	public EducacionModel guardarEducacion(@RequestBody EducacionModel educacion) {
		return this.educacionService.guardarEducacion(educacion);
	}
	
	@PutMapping("/actualizar")
	public EducacionModel actualizarPersona(@RequestBody EducacionModel educacion) {
		return this.educacionService.actualizarEducacion(educacion);
	}
}
