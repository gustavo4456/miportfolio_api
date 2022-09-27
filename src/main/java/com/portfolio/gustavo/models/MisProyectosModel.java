package com.portfolio.gustavo.models;


import javax.persistence.*;

@Entity
@Table(name = "mis_proyectos")
public class MisProyectosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(unique = true, nullable = false)
	private Long idProyecto;
	private String nombre;
	private String fechaInicio;
	private String fechaFin;
	private String descripcion;
	private Long personaId;
	private String lenguaje;
	private String urlImg;
	private String urlGitHub;
	
	public MisProyectosModel() {
	}

	public MisProyectosModel(Long idProyecto, String nombre, String fechaInicio, String fechaFin, String descripcion,
			Long personaId, String lenguaje, String urlImg, String urlGitHub) {
		this.idProyecto = idProyecto;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
		this.personaId = personaId;
		this.lenguaje = lenguaje;
		this.urlImg = urlImg;
		this.urlGitHub = urlGitHub;
	}

	public MisProyectosModel(String nombre, String fechaInicio, String fechaFin, String descripcion, Long personaId,
			String lenguaje, String urlImg, String urlGitHub) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descripcion = descripcion;
		this.personaId = personaId;
		this.lenguaje = lenguaje;
		this.urlImg = urlImg;
		this.urlGitHub = urlGitHub;
	}

	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public String getUrlGitHub() {
		return urlGitHub;
	}

	public void setUrlGitHub(String urlGitHub) {
		this.urlGitHub = urlGitHub;
	}

	@Override
	public String toString() {
		return "MisProyectosModel [descripcion=" + descripcion + ", fechaFin=" + fechaFin + ", fechaInicio="
				+ fechaInicio + ", idProyecto=" + idProyecto + ", lenguaje=" + lenguaje + ", nombre=" + nombre
				+ ", personaId=" + personaId + ", urlGitHub=" + urlGitHub + ", urlImg=" + urlImg + "]";
	}

	
	

}
