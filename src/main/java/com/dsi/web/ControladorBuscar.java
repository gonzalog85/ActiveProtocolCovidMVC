package com.dsi.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.dsi.domain.Asignacion;
import com.dsi.domain.Persona;
import com.dsi.model.BuscarForm;
import com.dsi.service.AsignacionService;
import com.dsi.service.PersonaService;

@Controller
public class ControladorBuscar {

	@Autowired
	PersonaService personaService;

	@Autowired
	AsignacionService asignacionService;

	// Busqueda por dni
	@GetMapping("/inicioProtocolo")
	public String PreparaForm(Model model) {
		model.addAttribute("personaForm", new BuscarForm());
		return "inicioProtocolo";
	}

	@GetMapping("/inicioProtocolo/dni/dias")
	public String buscarPorDni(@RequestParam Integer dni, @RequestParam Integer dias, Model model,
			@ModelAttribute("personaForm") @Valid BuscarForm persona, BindingResult result) throws ParseException {

		if (result.hasErrors()) {
			return "inicioProtocolo";
		}
		var busqueda = personaService.buscarPorDni(dni);

		var d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String hoy = df.format(new Date());
		String desde = df.format((d.getTime() - dias * 24 * 60 * 60 * 1000));

		var asignaciones = asignacionService.BuscarAsignacionesEntreFechas(df.parse(desde), df.parse(hoy));
		var ab = busqueda.getAsignaciones();//asignaciones de la persona encontrada
		Set<Persona> contactos = new HashSet<>();

		for (Asignacion a : asignaciones) {
			for (Asignacion b : ab) {
				if (a.getClase().equals(b.getClase())) {
					contactos.add(a.getPersona());
				}
			}
		}

		contactos.remove(busqueda);

		model.addAttribute("contactos", contactos);
		model.addAttribute("busqueda", busqueda);
//		model.addAttribute("personaForm", persona);
		return "inicioProtocolo";

	}

}
