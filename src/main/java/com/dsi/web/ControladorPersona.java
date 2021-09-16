package com.dsi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.dsi.domain.*;
import com.dsi.service.PersonaService;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class ControladorPersona {

	@Autowired
	private PersonaService personaService;
	
	//PERSONAS
	
	
	
	
	//ALUMNOS
	
	@GetMapping("/alumnos")
	public String alumnos(Model model) {		
		var alumnos = personaService.listarAlumnos();
		model.addAttribute("alumnos", alumnos);
		log.info("Cargando listado de alumnos");
		return "alumnos";
	}
	
	@GetMapping("/agregarAlumno")
	public String agregarAlumno(Alumno alumno) {
		return "agregarAlumno";
	}
	
	@GetMapping("/alumnos/editar/{idPersona}")
    public String editarAlumno(Persona alumno, Model model){
		
		alumno = personaService.encontrarPersona(alumno);
        
        model.addAttribute("persona", alumno);
        	return "modificarAlumno";
    }
	
	@PostMapping("/guardarAlumno")
	public String guardarAlumno(Alumno alumno) {
			
		personaService.guardar(alumno);
		return "redirect:/alumnos";
	}
	
	 @GetMapping("/alumnos/eliminarAlumno")
	    public String eliminarAlumno(Persona alumno){
	        personaService.eliminarAlumno(alumno);
	        return "redirect:/alumnos";
	    }
	
	//DOCENTES
	
	@GetMapping("/docentes")
	public String docentes(Model model) {		
		var docentes = personaService.listarDocentes();
		model.addAttribute("docentes", docentes);
		return "docentes";
	}
	
	@GetMapping("/agregarDocente")
	public String agregarDocente(Docente docente) {
		return "agregarDocente";
	}
	
	@GetMapping("/docentes/editar/{idPersona}")
    public String editarDocente(Persona docente, Model model){
		
		docente = personaService.encontrarPersona(docente);
        
        model.addAttribute("persona", docente);
        	return "modificarDocente";
    }
	
	@PostMapping("/guardarDocente")
	public String guardarDocente(Docente docente) {
		
		personaService.guardar(docente);
		
		 return "redirect:/docentes";
	}
	
	 @GetMapping("/docentes/eliminarDocente/{idPersona}")
	    public String eliminarDocente(Docente docente){
	        personaService.eliminarDocente(docente);
	        return "redirect:/docentes";
	    }
	
}
