package com.portfolio.gustavo.models;



import javax.persistence.*;

@Entity
@Table(name = "persona")
public class PersonaModel {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	private String nombre;
	private String apellido;
	private String fechaNacimiento;
	private Long  celular;
	private String correo;
	private String presentacionPrincipal;
	private String presentacionSecundaria;
	
	
	
	
	public PersonaModel() {
		super();
	}




	public PersonaModel(String nombre, String apellido, String fechaNacimiento, Long celular, String correo,
			String presentacionPrincipal, String presentacionSecundaria) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.correo = correo;
		this.presentacionPrincipal = presentacionPrincipal;
		this.presentacionSecundaria = presentacionSecundaria;
	}




	public PersonaModel(Long idPersona, String nombre, String apellido, String fechaNacimiento, Long celular,
			String correo, String presentacionPrincipal, String presentacionSecundaria) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.correo = correo;
		this.presentacionPrincipal = presentacionPrincipal;
		this.presentacionSecundaria = presentacionSecundaria;
	}




	public Long getIdPersona() {
		return idPersona;
	}




	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getFechaNacimiento() {
		return fechaNacimiento;
	}




	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}




	public Long getCelular() {
		return celular;
	}




	public void setCelular(Long celular) {
		this.celular = celular;
	}




	public String getCorreo() {
		return correo;
	}




	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public String getPresentacionPrincipal() {
		return presentacionPrincipal;
	}




	public void setPresentacionPrincipal(String presentacionPrincipal) {
		this.presentacionPrincipal = presentacionPrincipal;
	}




	public String getPresentacionSecundaria() {
		return presentacionSecundaria;
	}




	public void setPresentacionSecundaria(String presentacionSecundaria) {
		this.presentacionSecundaria = presentacionSecundaria;
	}




	@Override
	public String toString() {
		return "PersonaModel [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", celular=" + celular + ", correo=" + correo
				+ ", presentacionPrincipal=" + presentacionPrincipal + ", presentacionSecundaria="
				+ presentacionSecundaria + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
