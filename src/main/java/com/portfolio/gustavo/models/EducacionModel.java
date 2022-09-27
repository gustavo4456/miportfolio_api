package com.portfolio.gustavo.models;

import javax.persistence.*;


@Entity
@Table(name = "educacion")
public class EducacionModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long idEducacion;
	private String institucion;
	private String nivel;
	private String estado;
	private Long personaId;
	private String descripcion;
	
	public EducacionModel() {
	}

	public EducacionModel(Long idEducacion, String institucion, String nivel, String estado, Long personaId,
			String descripcion) {
		this.idEducacion = idEducacion;
		this.institucion = institucion;
		this.nivel = nivel;
		this.estado = estado;
		this.personaId = personaId;
		this.descripcion = descripcion;
	}

	public EducacionModel(String institucion, String nivel, String estado, Long personaId, String descripcion) {
		this.institucion = institucion;
		this.nivel = nivel;
		this.estado = estado;
		this.personaId = personaId;
		this.descripcion = descripcion;
	}

	public Long getIdEducacion() {
		return idEducacion;
	}

	public void setIdEducacion(Long idEducacion) {
		this.idEducacion = idEducacion;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "EducacionModel [descripcion=" + descripcion + ", estado=" + estado + ", idEducacion=" + idEducacion
				+ ", institucion=" + institucion + ", nivel=" + nivel + ", personaId=" + personaId + "]";
	}

	
	
	
}
