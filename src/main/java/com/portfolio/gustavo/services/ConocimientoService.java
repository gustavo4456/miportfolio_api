package com.portfolio.gustavo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.gustavo.models.ConocimientoModel;
import com.portfolio.gustavo.repositories.ConocimientoRepository;

@Service
public class ConocimientoService {
	@Autowired
	ConocimientoRepository conocimientoRepository;
	
	public ArrayList<ConocimientoModel> obtenerConocimiento(){
		return (ArrayList<ConocimientoModel>)conocimientoRepository.findAll();
	}

	//SE OBTIENE EL CONOCIMIENTO POR EL ID DE LA CONOCIMIENTO UNA SOLA
	public Optional<ConocimientoModel> obtenerConocimientoIdNoList(Long idConocimiento) {	
		return conocimientoRepository.findById(idConocimiento);
	}

	//ELIMINAR
	public void eliminarConocimiento(Long idConocimiento){
		conocimientoRepository.deleteById(idConocimiento);
	}
	
	public ArrayList<ConocimientoModel> obtenerConocimientoPorId(Long personaId){
		ArrayList<ConocimientoModel> conocimientoTodos = (ArrayList<ConocimientoModel>)conocimientoRepository.findAll();
		ArrayList<ConocimientoModel> conocimientoFiltro = new ArrayList<>();
		
		for (ConocimientoModel conocimientoModel : conocimientoTodos) {
			
			if(conocimientoModel.getPersonaId() == personaId) {
				
				conocimientoFiltro.add(conocimientoModel);
					
			}		
			
		}
		
		return conocimientoFiltro;
	}
	
	public ConocimientoModel guardarConocimiento(ConocimientoModel conocimiento) {
		return conocimientoRepository.save(conocimiento);
	}
	
	public ConocimientoModel actualizarConocimiento(ConocimientoModel conocimiento) {
		return conocimientoRepository.save(conocimiento);
	}
}
