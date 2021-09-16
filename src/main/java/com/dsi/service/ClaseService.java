package com.dsi.service;

import java.util.List;

import com.dsi.domain.Clase;

public interface ClaseService {

	public List<Clase> listarClases();
	
	public void guardar(Clase clase);
	
	public void eliminar(Clase clase);
	
	public Clase encontrarClase(Clase clase);
		
}
