package com.portfolio.gustavo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conocimiento")
public class ConocimientoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConocimiento;
	private Long personaId;
	private String nombre;
	private String nivel;

	public ConocimientoModel() {
	}

	public ConocimientoModel(Long idConocimiento, Long personaId, String nombre, String nivel) {
		this.idConocimiento = idConocimiento;
		this.personaId = personaId;
		this.nombre = nombre;
		this.nivel = nivel;
	}

	public ConocimientoModel(Long personaId, String nombre, String nivel) {
		this.personaId = personaId;
		this.nombre = nombre;
		this.nivel = nivel;
	}

	public Long getIdConocimiento() {
		return idConocimiento;
	}

	public void setIdConocimiento(Long idConocimiento) {
		this.idConocimiento = idConocimiento;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "ConocimientoModel [idConocimiento=" + idConocimiento + ", nivel=" + nivel + ", nombre=" + nombre
				+ ", personaId=" + personaId + "]";
	}
	

	
	
	

}
