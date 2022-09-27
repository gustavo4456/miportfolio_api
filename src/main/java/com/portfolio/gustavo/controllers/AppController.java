package com.portfolio.gustavo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portfolio.gustavo.models.ConocimientoModel;
import com.portfolio.gustavo.models.EducacionModel;
import com.portfolio.gustavo.models.HistorialLaboralModel;
import com.portfolio.gustavo.models.MisProyectosModel;
import com.portfolio.gustavo.models.PersonaModel;
import com.portfolio.gustavo.services.ConocimientoService;
import com.portfolio.gustavo.services.EducacionService;
import com.portfolio.gustavo.services.HistorialLaboralService;
import com.portfolio.gustavo.services.MisProyectosService;
import com.portfolio.gustavo.services.PersonaService;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class AppController {
	
	@Autowired
	private PersonaService personaService;

	@Autowired
	private EducacionService educacionService;

	@Autowired
	private ConocimientoService conocimientoService;

	@Autowired
	private MisProyectosService misProyectosService;

	@Autowired
	private HistorialLaboralService historialLaboralService;
	
	
	//INICIO DE SESION
	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}

	//MENU PARA SELECCION DE VISTA COMO USER O ADMIN
	
	@GetMapping({"/menu"})
	public String hello() {
		return "menu";
	}

	//VISTA PARA ADMIN Y USER, AQUI ESTA EL MENU CON LA LISTA DE LAS TABLAS
	
	@GetMapping({"/admin"})
	public String admin() {
		return "admin";
	}

	@GetMapping({"/user"})
	public String user() {
		return "user";
	}


	//PERSONA
	//PARA TABLA VER PERSONA CON PERMISO DE USER
	
	@GetMapping({"/user/ver_tabla_persona"})
	public String verPersona(Model model) {
		
		model.addAttribute("listaPersonas", personaService.obtenerPersonas());
		
		return "persona/ver_tabla_persona";
	}

	//PARA TABLA PERSONA CON PERMISO ADMIN
	
	@GetMapping({"/admin/ver_tabla_persona_admin"})
	public String verPersonaAdmin(Model model) {
		
		model.addAttribute("listaPersonas", personaService.obtenerPersonas());
		
		return "persona/ver_tabla_persona_admin";
	}
	
	@GetMapping({"/admin/agregar_persona"})
	public String agregarPersona(Model model) {

		model.addAttribute("persona", new PersonaModel());
		return "persona/modificar_persona";
	}
	
	@PostMapping({"/admin/agregar_persona/guardar"})
	public String guardarPersona(PersonaModel persona) {
		personaService.guardarPersona(persona);
		return "redirect:/admin/ver_tabla_persona_admin";
	}

	@GetMapping({"/admin/editar_persona/{idPersona}"})
	public String editarPersona(PersonaModel persona, Model model){

		persona = personaService.obtenerPersonaId(persona.getIdPersona()).orElse(null);
		model.addAttribute("persona", persona);

		return "persona/modificar_persona";
	}

	@GetMapping({"/admin/eliminar_persona"})
	public String eliminarPersona(PersonaModel persona){
		personaService.eliminarPersona(persona.getIdPersona());
		return "redirect:/admin/ver_tabla_persona_admin";
	}


	//EDUCACION
	//PARA LA TABLA EDUCACION CON PERMISO USER
	@GetMapping({"/user/ver_tabla_educacion"})
	public String verEducacion(Model model) {
		
		model.addAttribute("listaEducacion", educacionService.obtenerEducacion());
		
		return "educacion/ver_tabla_educacion";
	}
	

	//PARA TABLA EDUCACION CON PERMISO DE ADMIN

	@GetMapping({"/admin/ver_tabla_educacion_admin"})
	public String verEducacionAdmin(Model model) {
		
		model.addAttribute("listaEducacion", educacionService.obtenerEducacion());
		
		return "educacion/ver_tabla_educacion_admin";
	}

	@GetMapping({"/admin/agregar_educacion"})
	public String agregarEducacion(Model model) {

		model.addAttribute("educacion", new EducacionModel());
		return "educacion/modificar_educacion";
	}

	@PostMapping({"/admin/agregar_educacion/guardar"})
	public String guardarEducacion(EducacionModel educacion) {
		educacionService.guardarEducacion(educacion);
		return "redirect:/admin/ver_tabla_educacion_admin";
	}

	@GetMapping({"/admin/editar_educacion/{idEducacion}"})
	public String editarEducacion(EducacionModel educacion, Model model){

		educacion = educacionService.obtenerEducacionIdNoList(educacion.getIdEducacion()).orElse(null);

		model.addAttribute("educacion", educacion);

		return "educacion/modificar_educacion";
	}

	@GetMapping({"/admin/eliminar_educacion"})
	public String eliminarEducacion(EducacionModel educacion){
		educacionService.eliminarEducacion(educacion.getIdEducacion());
		return "redirect:/admin/ver_tabla_educacion_admin";
	}

	//CONOCIMIENTO
	//PARA LA TABLA CONOCIMIENTO CON PERMISOS DE USER
	@GetMapping({"/user/ver_tabla_conocimiento"})
	public String verConocimiento(Model model) {
		
		model.addAttribute("listaConocimiento", conocimientoService.obtenerConocimiento());
		
		return "conocimiento/ver_tabla_conocimiento";
	}

	//PARA TABLA CONOCIMIENTO CON PERMISO DE ADMIN

	@GetMapping({"/admin/ver_tabla_conocimiento_admin"})
	public String verConocimientoAdmin(Model model) {
		
		model.addAttribute("listaConocimiento", conocimientoService.obtenerConocimiento());
		
		return "conocimiento/ver_tabla_conocimiento_admin";
	}

	@GetMapping({"/admin/agregar_conocimiento"})
	public String agregarConocimiento(Model model) {

		model.addAttribute("conocimiento", new ConocimientoModel());
		return "conocimiento/modificar_conocimiento";
	}

	@PostMapping({"/admin/agregar_conocimiento/guardar"})
	public String guardarConocimiento(ConocimientoModel conocimiento) {
		conocimientoService.guardarConocimiento(conocimiento);
		return "redirect:/admin/ver_tabla_conocimiento_admin";
	}

	@GetMapping({"/admin/editar_conocimiento/{idConocimiento}"})
	public String editarConocimiento(ConocimientoModel conocimiento, Model model){

		conocimiento = conocimientoService.obtenerConocimientoIdNoList(conocimiento.getIdConocimiento()).orElse(null);

		model.addAttribute("conocimiento", conocimiento);

		return "conocimiento/modificar_conocimiento";
	}

	@GetMapping({"/admin/eliminar_conocimiento"})
	public String eliminarConocimiento(ConocimientoModel conocimiento){
		conocimientoService.eliminarConocimiento(conocimiento.getIdConocimiento());
		return "redirect:/admin/ver_tabla_conocimiento_admin";
	}

	//MIS PROYECTOS
	//PARA TABLA DE MIS PROYECTOS CON PERMISO DE USER
	@GetMapping({"/user/ver_tabla_proyecto"})
	public String verProyecto(Model model) {
		
		model.addAttribute("listaProyecto", misProyectosService.obtenerMisProyectos());
		
		return "proyectos/ver_tabla_proyecto";
	}



	//PARA TABLA MIS PROYECTOS CON PERMISO DE ADMIN

	@GetMapping({"/admin/ver_tabla_proyecto_admin"})
	public String verProyectoAdmin(Model model) {
		
		model.addAttribute("listaProyecto", misProyectosService.obtenerMisProyectos());
		
		return "proyectos/ver_tabla_proyecto_admin";
	}

	@GetMapping({"/admin/agregar_proyecto"})
	public String agregarProyecto(Model model) {

		model.addAttribute("proyecto", new MisProyectosModel());
		return "proyectos/modificar_proyecto";
	}

	@PostMapping({"/admin/agregar_proyecto/guardar"})
	public String guardarProyecto(MisProyectosModel proyecto) {
		misProyectosService.guardarMisProyectos(proyecto);
		return "redirect:/admin/ver_tabla_proyecto_admin";
	}

	@GetMapping({"/admin/editar_proyecto/{idProyecto}"})
	public String editarProyecto(MisProyectosModel proyecto, Model model){

		proyecto = misProyectosService.obteneProyectoIdNoList(proyecto.getIdProyecto()).orElse(null);

		model.addAttribute("proyecto", proyecto);

		return "proyectos/modificar_proyecto";
	}

	@GetMapping({"/admin/eliminar_proyecto"})
	public String eliminarProyecto(MisProyectosModel proyecto){
		misProyectosService.eliminarUnProyecto(proyecto.getIdProyecto());
		return "redirect:/admin/ver_tabla_proyecto_admin";
	}

	//HISTORIAL LABORAL
	//PARA LA TABLA HISTORIAL LABORAL CON PERMISO USER
	@GetMapping({"/user/ver_tabla_trabajo"})
	public String verTrabajo(Model model) {
		
		model.addAttribute("listaTrabajo", historialLaboralService.obtenerHistorialLaboral());
		
		return "trabajos/ver_tabla_trabajo";
	}

	//PARA TABLA HISTORIA LABORAL CON PERMISO DE ADMIN

	@GetMapping({"/admin/ver_tabla_trabajo_admin"})
	public String verTrabajoAdmin(Model model) {
		
		model.addAttribute("listaTrabajo", historialLaboralService.obtenerHistorialLaboral());
		
		return "trabajos/ver_tabla_trabajo_admin";
	}

	@GetMapping({"/admin/agregar_trabajo"})
	public String agregarTrabajo(Model model) {

		model.addAttribute("trabajo", new HistorialLaboralModel());
		return "trabajos/modificar_trabajo";
	}

	@PostMapping({"/admin/agregar_trabajo/guardar"})
	public String guardarTrabajo(HistorialLaboralModel trabajo) {
		historialLaboralService.guardarHistorial(trabajo);
		return "redirect:/admin/ver_tabla_trabajo_admin";
	}

	@GetMapping({"/admin/editar_trabajo/{idTrabajo}"})
	public String editarTrabajo(HistorialLaboralModel trabajo, Model model){

		trabajo = historialLaboralService.obtenerTrabajosIdNoList(trabajo.getIdTrabajo()).orElse(null);

		model.addAttribute("trabajo", trabajo);

		return "trabajos/modificar_trabajo";
	}

	@GetMapping({"/admin/eliminar_trabajo"})
	public String eliminarTrabajo(HistorialLaboralModel trabajo){
		historialLaboralService.eliminarUnTrabajo(trabajo.getIdTrabajo());
		return "redirect:/admin/ver_tabla_trabajo_admin";
	}


	
	
}
