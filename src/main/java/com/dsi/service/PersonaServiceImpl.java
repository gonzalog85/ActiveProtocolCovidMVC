package com.dsi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsi.dao.PersonaDao;
import com.dsi.domain.Alumno;
import com.dsi.domain.Docente;
import com.dsi.domain.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaDao<Persona> personaDao;
	@Autowired
	private PersonaDao<Alumno> alumnoRepo;
	@Autowired
	private PersonaDao<Docente> docenteRepo;

	@Override
	@Transactional(readOnly = true)
	public List<Persona> listarPersonas() {
		return personaDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Persona persona) {
		personaDao.saveAndFlush(persona);
		
	}
	
	@Override
	public Persona encontrarAlumno(Long id) {
		return alumnoRepo.findByIdPersona(id);
	}

	@Override
	@Transactional
	public void eliminarAlumno(Persona alumno) {
		this.personaDao.delete(alumno);
	}
	
	@Override
	@Transactional
	public void eliminarDocente(Docente docente) {
		docenteRepo.delete(docente);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona encontrarPersona(Persona persona) {
		
		return personaDao.getById(persona.getIdPersona());
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> listarAlumnos() {
		
		return alumnoRepo.findAllAlumnos();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Docente> listarDocentes() {
		
		return personaDao.findAllDocentes();
	}

	@Override
	@Transactional(readOnly = true)
	public Persona buscarPorDni(Integer dni) {
		
		return personaDao.findByDni(dni);
	}

	

	@Override
	@Transactional(readOnly = true)
	public List<Persona> BuscarPersonasEntreFechas(Date des, Date has, Long id) {
		return personaDao.BuscarPersonasEntreFechas(des, has, id);
	}

	



	

	

	

}
