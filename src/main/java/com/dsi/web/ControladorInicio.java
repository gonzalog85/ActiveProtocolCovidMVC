package com.dsi.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dsi.domain.Asignacion;
import com.dsi.domain.Persona;
import com.dsi.domain.Protocolo;
import com.dsi.service.PersonaService;
import com.dsi.service.ProtocoloService;

@Controller
public class ControladorInicio {

	@Autowired
	ProtocoloService protocoloService;

	@Autowired
	PersonaService personaService;

	@GetMapping("/")
	public String personas(Model model) {
		var protocolos = protocoloService.listarProtocolos();
		List<Persona> personas = new ArrayList<Persona>();
		var contador = 0;

		for (Protocolo p : protocolos) {
			personas = p.getPersonas();
			contador += personas.size();
		}

		model.addAttribute("protocolos", protocolos);
		model.addAttribute("totalProtocolos", protocolos.size());
		model.addAttribute("totalPersonas", contador);
		return "index";
	}

	@GetMapping("/detalle/{idProtocolo}")
	public String detalleProtocolo(Protocolo protocolo, Model model) {
		protocolo = protocoloService.encontrarProtocolo(protocolo);
		var dniString = protocolo.getNombre();

		var positivo = new Persona();
		var contactos = new ArrayList<Persona>();
		var personas = protocolo.getPersonas();
		for (Persona p : personas) {
			if (p.getDni() == Integer.parseInt(dniString)) {
				positivo = p;
			} else {
				contactos.add(p);
			}
		}

		model.addAttribute("positivo", positivo);
		model.addAttribute("protocolo", protocolo);
		model.addAttribute("contactos", contactos);
		return "detalleProtocolo";
	}

	@GetMapping("/eliminar")
	public String eliminarProtocolo(Protocolo protocolo) {
		protocolo = protocoloService.encontrarProtocolo(protocolo);
		var personas = protocolo.getPersonas();
		List<Asignacion> asignaciones = new ArrayList<>();
		for (Persona p : personas) {
			p.setEstado(null);
			asignaciones = p.getAsignaciones();
		}
		for (Asignacion a : asignaciones) {
			var clase = a.getClase();
			clase.setEstado(null);
		}
		protocoloService.eliminar(protocolo);
		return "redirect:/";
	}

}
