package com.teamdev.opticacheguigo.opticacheguigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.ClienteDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.UsuarioPassEncrypt;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.cp.CPValidoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;
import com.teamdev.opticacheguigo.opticacheguigo.service.CodigoPostalService;
import com.teamdev.opticacheguigo.opticacheguigo.service.PacienteService;
import com.teamdev.opticacheguigo.opticacheguigo.service.UsuarioService;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	private static final String REGISTRO_PACIENTE="registroPaciente";
	
	@Autowired
	CodigoPostalService codigoPostalService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PacienteService pacienteService;
	
	@GetMapping({"/registro"})
	public ModelAndView viewRegistroPaciente() {
		return new ModelAndView(REGISTRO_PACIENTE);
	}
	
	@GetMapping("/codigoCP/{cp}")
	public List<CPValidoDto> consultaCp(@PathVariable(name="cp") String cp) {
		return codigoPostalService.getListCP(cp);
		
	}
	
	
	@PostMapping(path = "/registro")
	public ModelAndView registrarPaciente(@ModelAttribute ClienteDto paciente) {
		ResponseGeneric response= pacienteService.guardarPaciente(pacienteService.converToMayus(paciente), getUsuario());
		return new ModelAndView(REGISTRO_PACIENTE).addObject("responseAlta",response);
	}
	
	
	
	public AuthHeader getUsuario() {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		UsuarioPassEncrypt myPass= usuarioService.passEncryp(userDetails.getUsername());
		return new AuthHeader(userDetails.getUsername(),myPass.getPassEncrypt());
		
	}
	
	
}
