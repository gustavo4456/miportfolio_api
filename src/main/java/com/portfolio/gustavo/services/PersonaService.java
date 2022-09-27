package com.portfolio.gustavo.services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.gustavo.models.PersonaModel;
import com.portfolio.gustavo.repositories.PersonaRepository;

@Service
public class PersonaService {
	@Autowired
	private PersonaRepository personaRepository;

	public ArrayList<PersonaModel> obtenerPersonas() {
		
		return (ArrayList<PersonaModel>) personaRepository.findAll();
	}

	public void eliminarPersona(Long idPersona){
		personaRepository.deleteById(idPersona);
	}
	
	public Optional<PersonaModel> obtenerPersonaId(Long idPersona) {
		Optional<PersonaModel> personaPorId = personaRepository.findById(idPersona);
		
		actualizarPersona(personaPorId.get());
		
		return personaRepository.findById(idPersona);
	}

	public PersonaModel guardarPersona(PersonaModel persona) {

		Calendar cal = new GregorianCalendar();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		int mesActual;
		int anioActual;
		int diaActual;
		
		int anioNacimiento;
		int mesNacimiento;
		int diaNacimiento;
		
		int mesResultado;
		int diaResultado;
		int anioResultado;
		
		
		try {
			
			mesActual = cal.get(Calendar.MONTH);
			anioActual = cal.get(Calendar.YEAR);
			diaActual = cal.get(Calendar.DAY_OF_MONTH);
			
			Date dataFormateada = formato.parse(persona.getFechaNacimiento());
			cal.setTime(dataFormateada);
			
			anioNacimiento = cal.get(Calendar.YEAR);
			mesNacimiento = cal.get(Calendar.MONTH);
			diaNacimiento = cal.get(Calendar.DAY_OF_MONTH);
			
			mesResultado = Math.abs(mesNacimiento - mesActual);
			diaResultado = Math.abs(diaNacimiento - diaActual);
			anioResultado = Math.abs(anioNacimiento - anioActual);
			
			if(anioActual > anioNacimiento) {
				if(mesActual == mesNacimiento && diaActual < diaNacimiento ) {
					
					anioResultado -= 1;
					
				}else if(mesActual < mesNacimiento) {
					anioResultado -= 1;
				}
				
			}
			
			
			persona.setPresentacionPrincipal("Hola mi nombre es " + persona.getNombre() + " " + persona.getApellido()
			+ " tengo " + anioResultado + " años y soy estudiante de ing. en sistemas y de lic. sistemas "
			+ "en la universidad nacional de La Rioja.");
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		

		persona.setPresentacionSecundaria("Desde mi infancia me gustan las computadoras y "
				+ "el software, me interesaba saber como se construian los juegos o programas que"
				+ " usaba o paginas que visitaba es asi como tome la decision de estudiar sistemas y "
				+ "despues aprender por mi propia cuenta en la web.");
        
		

		

		
		return personaRepository.save(persona);
	}
	
	public PersonaModel actualizarPersona(PersonaModel persona) {
		
		Calendar cal = new GregorianCalendar();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		int mesActual;
		int anioActual;
		int diaActual;
		
		int anioNacimiento;
		int mesNacimiento;
		int diaNacimiento;
		
		int mesResultado;
		int diaResultado;
		int anioResultado;
		
		
		try {
			
			mesActual = cal.get(Calendar.MONTH);
			anioActual = cal.get(Calendar.YEAR);
			diaActual = cal.get(Calendar.DAY_OF_MONTH);
			
			Date dataFormateada = formato.parse(persona.getFechaNacimiento());
			cal.setTime(dataFormateada);
			
			anioNacimiento = cal.get(Calendar.YEAR);
			mesNacimiento = cal.get(Calendar.MONTH);
			diaNacimiento = cal.get(Calendar.DAY_OF_MONTH);
			
			mesResultado = Math.abs(mesNacimiento - mesActual);
			diaResultado = Math.abs(diaNacimiento - diaActual);
			anioResultado = Math.abs(anioNacimiento - anioActual);
			
			if(anioActual > anioNacimiento) {
				if(mesActual == mesNacimiento && diaActual < diaNacimiento ) {
					
					anioResultado -= 1;
					
				}else if(mesActual < mesNacimiento) {
					anioResultado -= 1;
				}
				
			}
			
			
			persona.setPresentacionPrincipal("Hola mi nombre es " + persona.getNombre() + " " + persona.getApellido()
			+ " tengo " + anioResultado + " años y soy estudiante de ing. en sistemas y de lic. sistemas "
			+ "en la universidad nacional de La Rioja.");
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

		

		persona.setPresentacionSecundaria("Desde mi infancia me gustan las computadoras y "
				+ "el software, me interesaba saber como se construian los juegos o programas que"
				+ " usaba o paginas que visitaba es asi como tome la decision de estudiar sistemas y "
				+ "despues aprender por mi propia cuenta en la web.");
        
		

		

		
		return personaRepository.save(persona);
	}
	

}
