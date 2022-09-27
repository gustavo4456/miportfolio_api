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

import com.portfolio.gustavo.models.ConocimientoModel;
import com.portfolio.gustavo.services.ConocimientoService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/conocimiento")
public class ConocimientoController {
	@Autowired
	ConocimientoService conocimientoService;
	
	@GetMapping()
	public ArrayList<ConocimientoModel> obtenerConocimiento(){
		return conocimientoService.obtenerConocimiento();
	}
	
	@GetMapping("/por_id")
	@ResponseBody
	public ArrayList<ConocimientoModel> obtenerConocimientoPorId(@RequestParam Long id_persona){
		return conocimientoService.obtenerConocimientoPorId(id_persona);
	}
	
	@PostMapping
	public ConocimientoModel guardarConocimiento(@RequestBody ConocimientoModel conocimiento) {
		return this.conocimientoService.guardarConocimiento(conocimiento);
	}
	
	@PutMapping("/actualizar")
	public ConocimientoModel actualizarConocimiento(@RequestBody ConocimientoModel conocimiento) {
		return this.conocimientoService.actualizarConocimiento(conocimiento);
	}

}
