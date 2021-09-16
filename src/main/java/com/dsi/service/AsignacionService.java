package com.dsi.service;

import java.util.Date;
import java.util.List;

import com.dsi.domain.Asignacion;

public interface AsignacionService {

	public List<Asignacion> listarAsignaciones();
	
	public void guardar(Asignacion asignacion);
	
	public void eliminar(Asignacion asignacion);
	
	public Asignacion encontrarAsignacion(Long id);
	
	public List<Asignacion> BuscarAsignacionesEntreFechas(Date des, Date has);
}
