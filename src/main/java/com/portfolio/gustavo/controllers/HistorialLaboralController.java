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

import com.portfolio.gustavo.models.HistorialLaboralModel;
import com.portfolio.gustavo.services.HistorialLaboralService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/historial_laboral")
public class HistorialLaboralController {
	@Autowired
	HistorialLaboralService historialLaboralService;
	
	@GetMapping()
	public ArrayList<HistorialLaboralModel> obtenerHistorialLaboral(){
		return historialLaboralService.obtenerHistorialLaboral();
	}
	
	@GetMapping("/por_id")
	@ResponseBody
	public ArrayList<HistorialLaboralModel> obtenerHistorialLaboralPorId(@RequestParam Long id_persona){
		return historialLaboralService.obtenerHistorialLaboralPorId(id_persona);
	}
	
	
	@PostMapping()
	public HistorialLaboralModel guardarHistorialLaboral(@RequestBody HistorialLaboralModel historialLaboral) {
		return this.historialLaboralService.guardarHistorial(historialLaboral);
	}
	
	@PutMapping("/actualizar")
	public HistorialLaboralModel actualizarHistorialLaboral(@RequestBody HistorialLaboralModel historialLaboral) {
		return this.historialLaboralService.actualizarHistorial(historialLaboral);
	}
}
