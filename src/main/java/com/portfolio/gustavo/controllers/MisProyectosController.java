package com.portfolio.gustavo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.gustavo.models.EducacionModel;
import com.portfolio.gustavo.models.MisProyectosModel;
import com.portfolio.gustavo.services.MisProyectosService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/mis_proyectos")
public class MisProyectosController {
	@Autowired
	MisProyectosService misProyectosService;
	
	@PostMapping()
	public MisProyectosModel guardarMisProyectos(@RequestBody MisProyectosModel misProyectos) {
		return this.misProyectosService.guardarMisProyectos(misProyectos);
	}
	
	@GetMapping()
	public ArrayList<MisProyectosModel> obtenerMisProyectos(){
		return misProyectosService.obtenerMisProyectos();
	}
	
	@GetMapping("/por_id")
	@ResponseBody
	public ArrayList<MisProyectosModel> obtenerMisProyectosPorId(@RequestParam Long id_persona){
		return misProyectosService.obtenerMisProyectosPorId(id_persona);
	}
	
	
	
	@DeleteMapping("/borrar/por_id")
	@ResponseBody
	public void eliminarUnProyecto(@RequestParam Long id_proyecto){
		 misProyectosService.eliminarUnProyecto(id_proyecto);
	}
	
}
