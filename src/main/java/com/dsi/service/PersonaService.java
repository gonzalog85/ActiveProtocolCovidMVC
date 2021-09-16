package com.dsi.service;

import java.util.Date;
import java.util.List;

import com.dsi.domain.Alumno;
import com.dsi.domain.Docente;
import com.dsi.domain.Persona;

public interface PersonaService {

	public List<Persona> listarPersonas();
	
	public List<Alumno> listarAlumnos();
	
	public List<Docente> listarDocentes();
	
	public void guardar(Persona persona);
	
	public void eliminarAlumno(Persona alumno);
	public void eliminarDocente(Docente docente);
	
	public Persona encontrarPersona(Persona persona);
	public Persona encontrarAlumno(Long id);
	
	public Persona buscarPorDni(Integer dni);
	
	
	
	List<Persona> BuscarPersonasEntreFechas(Date des, Date has, Long id);
	
	
	
	
}
