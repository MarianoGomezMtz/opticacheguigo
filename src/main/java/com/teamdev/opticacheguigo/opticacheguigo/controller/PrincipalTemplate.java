package com.teamdev.opticacheguigo.opticacheguigo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PrincipalTemplate {
	
	@GetMapping("/")
	public ModelAndView index() {
		
		return new ModelAndView("main");
	}
	
	
	@GetMapping("/armazones")
	public ModelAndView viewArmazon() {
		
		return new ModelAndView("gestionArmazon");
	}
	
	@GetMapping("/agenda")
	public ModelAndView viewAgenda() {
		
		return new ModelAndView("agenda");
	}
	
	@GetMapping("/procesoVenta")
	public ModelAndView viewVenta() {
		
		return new ModelAndView("procesoVenta");
	}
	
	

}
