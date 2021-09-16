package com.dsi.model;

import javax.validation.constraints.NotEmpty;


import lombok.Data;

@Data
public class AsignacionForm {
	
	@NotEmpty
	private String persona;

	@NotEmpty
	private String clase;

	@NotEmpty
	private String fecha;

}
