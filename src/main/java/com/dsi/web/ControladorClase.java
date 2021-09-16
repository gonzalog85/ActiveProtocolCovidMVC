package com.dsi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsi.domain.Clase;
import com.dsi.domain.Curso;
import com.dsi.service.ClaseService;
import com.dsi.service.CursoService;

@Controller
@RequestMapping("/clase")
public class ControladorClase {

	@Autowired
	private ClaseService claseService;
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/listado")
	public String listado (Model model) {
		var clases = this.claseService.listarClases();
		model.addAttribute("clases", clases);
		return "clases";
	}
	
	@GetMapping("/agregarClase")
	public String agregarAsignacion(Clase clase) {
		return "agregarClase";
	}
	
	 @ModelAttribute("allCursos")
	    public List<Curso> AllCursos() {
	        return this.cursoService.listarCursos();
	    }
	 
	  
	  @PostMapping("/guardarClase")
		public String guardarClase(Clase clase) {
		  this.claseService.guardar(clase);
			return "redirect:/clase/listado";
		}
	  
	  @GetMapping("/eliminar{id}")
	  public String eliminar (Clase clase) {
		  this.claseService.eliminar(clase);
		  return "redirect:/clase/listado";
	  }
}
