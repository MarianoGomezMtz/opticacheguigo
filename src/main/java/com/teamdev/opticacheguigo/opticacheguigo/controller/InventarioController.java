package com.teamdev.opticacheguigo.opticacheguigo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.UsuarioPassEncrypt;
import com.teamdev.opticacheguigo.opticacheguigo.service.UsuarioService;
import com.teamdev.opticacheguigo.opticacheguigo.service.ViewsInventarioService;


@RestController
@RequestMapping("/inventario")
public class InventarioController {
	
	@Autowired
	ViewsInventarioService viewInventario;
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/template")
	public ModelAndView main() {
		
		return new ModelAndView("main");
	}
	
	
	@GetMapping("/armazones")
	public ModelAndView viewArmazon() {
		AuthHeader userSesion = getUsuario();
		System.out.println("usuario: "+userSesion.getUsername());
		System.out.println("password: "+userSesion.getPassword());
		return viewInventario.inventarioArmazon();
		//return new ModelAndView("gestionArmazon");
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
		AuthHeader userSesion = getUsuario();
		System.out.println("usuario: "+userSesion.getUsername());
		System.out.println("password: "+userSesion.getPassword());
		return new ModelAndView("tratamiento");
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
