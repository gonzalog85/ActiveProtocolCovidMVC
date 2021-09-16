package com.dsi.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.dsi.domain.Asignacion;
import com.dsi.domain.Persona;
import com.dsi.domain.Protocolo;
import com.dsi.service.AsignacionService;
import com.dsi.service.EstadoService;
import com.dsi.service.MailService;
import com.dsi.service.PersonaService;
import com.dsi.service.ProtocoloService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/inicioProtocolo")
public class ControladorProtocolo {

	@Autowired
	private PersonaService personaService;
	@Autowired
	private ProtocoloService protocoloService;
	@Autowired
	private EstadoService estadoService;
	@Autowired
	private AsignacionService asignacionService;
	@Autowired
	private MailService mailService;

	// inicio protocolo
	// ruta: /inicioProtocolo/activar/
	// BUSCAR

	// BUSCAR

	@GetMapping("/iniciar{id}{dias}")
	public String iniciar(@RequestParam Long id, @RequestParam Integer dias, Model model) throws ParseException {
		Protocolo protocolo = new Protocolo();
		Persona persona = new Persona();
		persona.setIdPersona(id);
		persona = personaService.encontrarPersona(persona);
		log.info("INICIAR PROTOCOLO");

		protocolo.setNombre(persona.getDni().toString());

		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String hoy = df.format(d);
		String fin = df.format((d.getTime() + 15 * 24 * 60 * 60 * 1000));
		String desde = df.format((d.getTime() - dias * 24 * 60 * 60 * 1000));

		protocolo.setFechaInicio(df.parse(hoy));
		protocolo.setFechaFin(df.parse(fin));

		List<Persona> personas = new ArrayList<>();
		var estadoPositivo = estadoService.buscarPorNombre("positivo");
		var estadoAislado = estadoService.buscarPorNombre("aislado");
		var estadoSuspendido = estadoService.buscarPorNombre("suspendida");

		var asignaciones = asignacionService.BuscarAsignacionesEntreFechas(df.parse(desde), df.parse(hoy));
		var ap = persona.getAsignaciones();// asignaciones de la persona
//		Set<Persona> contactos = new HashSet<>();

		personas.add(persona);
		for (Asignacion a : asignaciones) {
			for (Asignacion b : ap) {
				if (a.getClase().equals(b.getClase()) && !a.getPersona().equals(persona)) {
					if(a.getPersona().getProtocolo() == null) {
						personas.add(a.getPersona());						
					}
				}
			}
		}

		protocolo.setPersonas(personas);

		// set estado aislado
		for (Persona p : personas) {
			if (persona.equals(p)) {
				p.setEstado(estadoPositivo);
			} else {
				p.setEstado(estadoAislado);
				this.mailService.sendEmail(p.getEmail(), "Contacto estrecho",
						"Se notifica que ha sido aislado por 15 dias por contacto estrecho con caso positivo por Covid");
			}
		}
		// set estado clase suspendida
		for (Asignacion a : ap) {
			a.getClase().setEstado(estadoSuspendido);
		}

		protocoloService.guardar(protocolo);

		return "redirect:/";
	}

}
