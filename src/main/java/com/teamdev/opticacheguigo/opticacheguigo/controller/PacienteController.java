package com.teamdev.opticacheguigo.opticacheguigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.cp.CPValidoDto;
import com.teamdev.opticacheguigo.opticacheguigo.service.CodigoPostalService;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	private static final String REGISTRO_PACIENTE="registroPaciente";
	
	@Autowired
	CodigoPostalService codigoPostalService;
	
	@GetMapping({"/registro"})
	public ModelAndView viewRegistroPaciente() {
		return new ModelAndView(REGISTRO_PACIENTE);
	}
	
	@GetMapping("/codigoCP/{cp}")
	public List<CPValidoDto> consultaCp(@PathVariable(name="cp") String cp) {
		return codigoPostalService.getListCP(cp);
		
	}
	
	
}
