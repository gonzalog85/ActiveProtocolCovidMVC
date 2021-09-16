package com.dsi.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dsi.domain.Alumno;
import com.dsi.domain.Docente;
import com.dsi.domain.Persona;

@Repository
public interface PersonaDao<T extends Persona> extends JpaRepository<T, Long> {

	Persona findByDni(int dni);
	Alumno findByIdPersona(Long id);
	

	@Transactional(readOnly = true)
	@Query(value = "SELECT * FROM Persona p INNER JOIN Asignacion a WHERE a.fecha BETWEEN ?1 AND ?2 AND a.id_persona = ?3",nativeQuery = true)
	List<Persona> BuscarPersonasEntreFechas(Date des, Date has, Long id);
	
	@Query("from Alumno")
	List<Alumno> findAllAlumnos();
	
	@Query("from Alumno")
	List<Alumno> findByDniAlumno(Integer dni);
	
	@Query("from Docente")
	List<Docente> findAllDocentes();
	
	
	@Query("from Docente")
	List<Docente> findByDniDocente();
	
	
	
}


