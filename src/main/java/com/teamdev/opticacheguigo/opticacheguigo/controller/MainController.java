package com.teamdev.opticacheguigo.opticacheguigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.StockProducto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.UsuarioPassEncrypt;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;
import com.teamdev.opticacheguigo.opticacheguigo.service.InventarioService;
import com.teamdev.opticacheguigo.opticacheguigo.service.UsuarioService;
import com.teamdev.opticacheguigo.opticacheguigo.service.ViewsInventarioService;


@RestController
public class MainController {
	
	
	private static final String VIEW_ARMAZON="gestionArmazon";
	private static final String VIEW_MICA="gestionMicas";
	private static final String VIEW_INSUMO="gestionInsumo";
	
	
	@Autowired
	ViewsInventarioService viewInventario;
	
	@Autowired
	InventarioService inventarioService; 
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/template")
	public ModelAndView main() {
		
		return new ModelAndView("main");
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
	
	
	/**
	 * Create an instance of the type {@link ModelAndView}
	 * @return Instance of the type {@link ModelAndView}
	 */
	@GetMapping("/tratamiento")
	public ModelAndView viewTratamiento(){
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
