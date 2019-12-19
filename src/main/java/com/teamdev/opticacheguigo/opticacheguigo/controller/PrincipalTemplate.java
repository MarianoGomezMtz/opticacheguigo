package com.teamdev.opticacheguigo.opticacheguigo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PrincipalTemplate {
	
	@GetMapping("/template")
	public ModelAndView index() {
		
		return new ModelAndView("main");
	}
	
	
	@GetMapping("/armazones")
	public ModelAndView viewArmazon() {
		
		return new ModelAndView("gestionArmazon");
	}
	
	@GetMapping("/micas")
	public ModelAndView viewMicas() {
		
		return new ModelAndView("gestionMicas");
	}
	
	@GetMapping("/agenda")
	public ModelAndView viewAgenda() {
		
		return new ModelAndView("agenda");
	}
	
	@GetMapping("/procesoVenta")
	public ModelAndView viewVenta() {
		
		return new ModelAndView("procesoVenta").addObject("title","Proceso de Venta");
	}
	
	@GetMapping("/pacientesEncontrados")
	public ModelAndView viewPacientes() {
		
		return new ModelAndView("resultBusquedaPacientes").addObject("title","Proceso de Venta");
	}
	
	@GetMapping("/agregarMicas")
	public ModelAndView viewAgregarMicas() {
		
		return new ModelAndView("agregarMicas");
	}

	/**
	 * Create an instance of the type {@link ModelAndView}
	 * @return Instance of the type {@link ModelAndView}
	 */
	@GetMapping("/tratamiento")
	public ModelAndView viewTratamiento(){

		return new ModelAndView("tratamiento");
	}

}
