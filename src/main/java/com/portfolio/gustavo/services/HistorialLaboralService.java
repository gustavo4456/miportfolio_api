package com.portfolio.gustavo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.gustavo.models.HistorialLaboralModel;
import com.portfolio.gustavo.repositories.HistorialLaboralRepository;

@Service
public class HistorialLaboralService {
	
	@Autowired
	HistorialLaboralRepository historialLaboralRepository;
	
	public ArrayList<HistorialLaboralModel> obtenerHistorialLaboral(){
		return (ArrayList<HistorialLaboralModel>)historialLaboralRepository.findAll();
	}

	public void eliminarUnTrabajo(Long idTrabajo){
		historialLaboralRepository.deleteById(idTrabajo);
	}

	//SE OBTIENE EL HISTORIAL LABORAL POR EL ID TRABAJO UNA SOLA
	public Optional<HistorialLaboralModel> obtenerTrabajosIdNoList(Long idTrabajo) {	
		return historialLaboralRepository.findById(idTrabajo);
	}
	
	public ArrayList<HistorialLaboralModel> obtenerHistorialLaboralPorId(Long personaId){
		ArrayList<HistorialLaboralModel> historialLaboralTodos = (ArrayList<HistorialLaboralModel>)historialLaboralRepository.findAll();
		ArrayList<HistorialLaboralModel> historialLaboralFiltro = new ArrayList<>();
		
		for (HistorialLaboralModel historialLaboralModel : historialLaboralTodos) {
			
			if(historialLaboralModel.getPersonaId() == personaId) {
				
				historialLaboralFiltro.add(historialLaboralModel);
					
			}		
			
		}
		
		return historialLaboralFiltro;
	}
	
	public HistorialLaboralModel guardarHistorial(HistorialLaboralModel historialLaboral) {
		return historialLaboralRepository.save(historialLaboral);
	}
	
	public HistorialLaboralModel actualizarHistorial(HistorialLaboralModel historialLaboral) {
		return historialLaboralRepository.save(historialLaboral);
	}
}
