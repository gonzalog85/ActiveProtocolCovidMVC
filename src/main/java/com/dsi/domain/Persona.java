package com.dsi.domain;


import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity(name = "persona")
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private Long idPersona;

	@NotNull
	private Integer dni;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido;

	@NotEmpty
	private String telefono;

	@Email
	@NotEmpty
	private String email;
	
	@ManyToOne()
	@JoinColumn(name = "id_protocolo", referencedColumnName = "id_protocolo")
	private Protocolo protocolo;
	
	@ManyToOne()
	@JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
	private Estado estado;
	
	@OneToMany()
	@JoinColumn(name="id_Persona")
	private List<Asignacion> asignaciones;
}
