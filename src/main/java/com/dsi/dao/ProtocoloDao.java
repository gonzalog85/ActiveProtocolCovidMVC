package com.dsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.domain.Protocolo;

public interface ProtocoloDao extends JpaRepository<Protocolo, Long>{
	
}
