package com.dsi.service;

import java.util.List;

import com.dsi.domain.Establecimiento;

public interface EstablecimientoService {

	public List<Establecimiento> listarEstablecimientos();
	
	public void guardar(Establecimiento establecimiento);
	
	public void eliminar(Establecimiento establecimiento);
	
	public Establecimiento encontrarEstablecimiento(Establecimiento establecimiento);
}
