package com.dsi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsi.domain.Curso;

public interface CursoDao extends JpaRepository<Curso, Long> {

}
