package com.portfolio.gustavo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.gustavo.models.EducacionModel;
import com.portfolio.gustavo.repositories.EducacionRepository;

@Service
public class EducacionService {
	@Autowired
	EducacionRepository educacionRepository;
	
	public ArrayList<EducacionModel> obtenerEducacion(){
		return (ArrayList<EducacionModel>)educacionRepository.findAll();
	}

	//SE OBTIENE LA EDUCACION POR EL ID DE LA EDUCACION UNA SOLA
	public Optional<EducacionModel> obtenerEducacionIdNoList(Long idEducacion) {	
		return educacionRepository.findById(idEducacion);
	}
	

	//SE OBTIENE LA EDUCACION DE UNA PERSONA EN ESPECIFICO
	public ArrayList<EducacionModel> obtenerEducacionPorId(Long personaId){
		
		ArrayList<EducacionModel> educacionTodas = (ArrayList<EducacionModel>)educacionRepository.findAll();
		ArrayList<EducacionModel> educacionFiltro = new ArrayList<>();
		
		for (EducacionModel educacionModel : educacionTodas) {
			
			if(educacionModel.getPersonaId() == personaId) {
				
				educacionFiltro.add(educacionModel);
					
			}		
			
		}
		
		return educacionFiltro;
	}
	
	public EducacionModel guardarEducacion(EducacionModel educacion) {
		return educacionRepository.save(educacion);
	}
	
	public EducacionModel actualizarEducacion(EducacionModel educacion) {
		return educacionRepository.save(educacion);
	}

	public void eliminarEducacion(Long idEducacion){
		educacionRepository.deleteById(idEducacion);
	}
	
}
