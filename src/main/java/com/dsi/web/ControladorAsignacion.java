package com.dsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsi.domain.Asignacion;
import com.dsi.domain.Clase;
import com.dsi.domain.Persona;
import com.dsi.service.AsignacionService;
import com.dsi.service.ClaseService;
import com.dsi.service.PersonaService;

@Controller
@RequestMapping("/asignacion")
public class ControladorAsignacion {
	
	@Autowired
	private AsignacionService asignacionService;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private ClaseService claseService;
	
	@GetMapping("/listado")
	public String listado (Model model) {
		var asignaciones = this.asignacionService.listarAsignaciones();
		model.addAttribute("asignaciones", asignaciones);
		return "asignaciones";
	}
	
	@GetMapping("/agregarAsignacion")
	public String agregarAsignacion(Asignacion asignacion) {
		return "agregarAsignacion";
	}
	
	  @ModelAttribute("allPersonas")
	    public List<Persona> AllPersonas() {
	        return this.personaService.listarPersonas();
	    }
	  
	  @ModelAttribute("allClases")
	    public List<Clase> AllClases() {
	        return this.claseService.listarClases();
	    }
	  
	  @PostMapping("/guardarAsignacion")
		public String guardarAsignacion(Asignacion asignacion) {
		  this.asignacionService.guardar(asignacion);
			return "redirect:/asignacion/listado";
		}
	  
	  @GetMapping("/eliminar{id}")
	  public String eliminar (Asignacion asignacion) {
		  this.asignacionService.eliminar(asignacion);
		  return "redirect:/asignacion/listado";
	  }

}
