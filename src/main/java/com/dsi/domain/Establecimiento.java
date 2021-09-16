package com.dsi.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Table(name = "establecimiento")
public class Establecimiento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_establecimiento")
	private Long idEstablecimiento;
	
	@NotEmpty
	private String nombre;
	
	@OneToMany()
	@JoinColumn(name="id_establecimiento")
	private List<Curso> cursos;
	
	@OneToMany(mappedBy = "establecimiento")
	private List<Protocolo> protocolos;

}
