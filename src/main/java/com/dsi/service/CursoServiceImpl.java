package com.dsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.dao.CursoDao;
import com.dsi.domain.Curso;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoDao cursoDao;
	
	@Override
	public List<Curso> listarCursos() {
		return cursoDao.findAll();
	}

	@Override
	public void guardar(Curso curso) {
		cursoDao.save(curso);
	}

	@Override
	public void eliminar(Curso curso) {
		cursoDao.delete(curso);
	}

	@Override
	public Curso encontrarCurso(Curso curso) {
		return cursoDao.getById(curso.getIdCurso());
	}

}
