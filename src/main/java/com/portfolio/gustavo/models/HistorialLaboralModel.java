package com.portfolio.gustavo.models;


import javax.persistence.*;


@Entity
@Table(name = "historial_laboral")
public class HistorialLaboralModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(unique = true, nullable = false)
	private Long idTrabajo;
	private String tipo;
	private String ocupacion;
	private String fechaInicio;
	private String fechaFin;
	private Long personaId;
	private String descripcion;
	
	public HistorialLaboralModel() {
	}

	public HistorialLaboralModel(Long idTrabajo, String tipo, String ocupacion, String fechaInicio, String fechaFin,
			Long personaId, String descripcion) {
		this.idTrabajo = idTrabajo;
		this.tipo = tipo;
		this.ocupacion = ocupacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.personaId = personaId;
		this.descripcion = descripcion;
	}

	public HistorialLaboralModel(String tipo, String ocupacion, String fechaInicio, String fechaFin, Long personaId,
			String descripcion) {
		this.tipo = tipo;
		this.ocupacion = ocupacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.personaId = personaId;
		this.descripcion = descripcion;
	}

	public Long getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(Long idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
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
		return "HistorialLaboralModel [descripcion=" + descripcion + ", fechaFin=" + fechaFin + ", fechaInicio="
				+ fechaInicio + ", idTrabajo=" + idTrabajo + ", ocupacion=" + ocupacion + ", personaId=" + personaId
				+ ", tipo=" + tipo + "]";
	}

	
	
}
