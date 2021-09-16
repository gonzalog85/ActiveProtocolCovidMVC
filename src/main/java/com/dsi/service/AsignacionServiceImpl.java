package com.dsi.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.dao.AsignacionDao;
import com.dsi.domain.Asignacion;

@Service
public class AsignacionServiceImpl implements AsignacionService {
	
	@Autowired
	AsignacionDao asignacionDao;

	@Override
	public List<Asignacion> listarAsignaciones() {
		return asignacionDao.findAll();
	}

	@Override
	public void guardar(Asignacion asignacion) {
		asignacionDao.save(asignacion);
	}

	@Override
	public void eliminar(Asignacion asignacion) {
		asignacionDao.delete(asignacion);
	}

	@Override
	public Asignacion encontrarAsignacion(Long id) {
		return asignacionDao.getById(id);
	}

	@Override
	public List<Asignacion> BuscarAsignacionesEntreFechas(Date des, Date has) {
		return asignacionDao.BuscarAsignacionesEntreFechas(des, has);
	}

}
