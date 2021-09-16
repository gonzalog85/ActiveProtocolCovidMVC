package com.dsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.domain.Estado;

public interface EstadoDao extends JpaRepository<Estado, Long> {
	public Estado findOneByNombre(String nombre);
}
