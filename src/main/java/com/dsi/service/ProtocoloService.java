package com.dsi.service;

import java.util.List;

import com.dsi.domain.Protocolo;


public interface ProtocoloService {

	public List<Protocolo> listarProtocolos();
	
	public void guardar(Protocolo protocolo);
	
	public void eliminar(Protocolo protocolo);
	
	public Protocolo encontrarProtocolo(Protocolo protocolo);
	
	
}
