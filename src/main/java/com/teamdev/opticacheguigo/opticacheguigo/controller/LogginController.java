package com.teamdev.opticacheguigo.opticacheguigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;

@Controller
public class LogginController {
	
	@GetMapping("/")
	public String redirecLogin() {
		
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public ModelAndView index() {
		
		return new ModelAndView("index");
	}
	
	
	

}
