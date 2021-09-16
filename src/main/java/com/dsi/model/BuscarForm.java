package com.dsi.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Data
public class BuscarForm {
	
	@NotNull(message = "Debe ingresar un dni")
	@Min(value=7000000, message="Debe ingresar un dni valido")
	private Integer dni;

	@NotNull(message = "Debe ingresar los dias")
	@Min(value=2, message="Debe ser mayor a 1")
	private Integer dias;

}
