package com.portfolio.gustavo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.gustavo.models.MisProyectosModel;
import com.portfolio.gustavo.repositories.MisProyectosRepository;

@Service
public class MisProyectosService {
	@Autowired
	MisProyectosRepository misProyectosRepository;
	
	public MisProyectosModel guardarMisProyectos(MisProyectosModel misProyectos) {
		return misProyectosRepository.save(misProyectos);
	}

	public ArrayList<MisProyectosModel> obtenerMisProyectos() {
		return (ArrayList<MisProyectosModel>) misProyectosRepository.findAll();
	}

	//SE OBTIENE el proyecto POR EL ID DE proyecto UNA SOLA
	public Optional<MisProyectosModel> obteneProyectoIdNoList(Long idProyecto) {	
		return misProyectosRepository.findById(idProyecto);
	}

	public ArrayList<MisProyectosModel> obtenerMisProyectosPorId(Long personaId) {

		ArrayList<MisProyectosModel> misProyectosTodos = (ArrayList<MisProyectosModel>) misProyectosRepository
				.findAll();
		ArrayList<MisProyectosModel> misProyectosFiltro = new ArrayList<>();

		for (MisProyectosModel misProyectosModel : misProyectosTodos) {

			if (misProyectosModel.getPersonaId() == personaId) {

				misProyectosFiltro.add(misProyectosModel);

			}

		}

		return misProyectosFiltro;
	}
	
	public void eliminarUnProyecto(Long id) {
		misProyectosRepository.deleteById(id);
	}
}
