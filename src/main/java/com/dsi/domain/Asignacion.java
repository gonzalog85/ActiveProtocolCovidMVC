package com.dsi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "asignacion")
public class Asignacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asignacion")
	private Long idAsignacion;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
	private Clase clase;

}
