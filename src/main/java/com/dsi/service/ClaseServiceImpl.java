package com.dsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.dao.ClaseDao;
import com.dsi.domain.Clase;

@Service
public class ClaseServiceImpl implements ClaseService {

	@Autowired
	ClaseDao claseDao;
	
	@Override
	public List<Clase> listarClases() {
		return claseDao.findAll();
	}

	@Override
	public void guardar(Clase clase) {
		claseDao.save(clase);
	}

	@Override
	public void eliminar(Clase clase) {
		claseDao.delete(clase);
	}

	@Override
	public Clase encontrarClase(Clase clase) {
		return claseDao.getById(clase.getIdClase());
	}

}
