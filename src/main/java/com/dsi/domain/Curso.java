package com.dsi.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Table(name = "curso")
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Long idCurso;
	
	@NotEmpty
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_establecimiento", referencedColumnName = "id_establecimiento")
	private Establecimiento establecimiento;
	
	@OneToMany(mappedBy = "curso")
	private List<Clase> clases;
}
