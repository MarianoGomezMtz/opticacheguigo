package com.teamdev.opticacheguigo.opticacheguigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.teamdev.opticacheguigo.opticacheguigo.service.CatalogoService;
import com.teamdev.opticacheguigo.opticacheguigo.service.InventarioService;
import com.teamdev.opticacheguigo.opticacheguigo.service.UsuarioService;
import com.teamdev.opticacheguigo.opticacheguigo.service.ViewsCatalogoService;
import com.teamdev.opticacheguigo.opticacheguigo.service.ViewsInventarioService;


@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
	
	
	private static final String VIEW_ARMAZON="catalogoArmazon";
	private static final String VIEW_MICA="catalogoMica";
	private static final String VIEW_INSUMO="catalogoInsumo";
	
	
	@Autowired
	ViewsInventarioService viewInventario;
	
	@Autowired
	ViewsCatalogoService catalogoService; 
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	InventarioService inventarioService;
	
	@GetMapping("/armazon")
	public ModelAndView viewArmazon() {
		
		return new ModelAndView(VIEW_ARMAZON).addObject("codOperacion",3)
				.addObject("mensaje","")
				.addObject("productoError",new ProductoDto())
				.addObject("productos", inventarioService.productsByCatgory(1, getUsuario()));
	}
	
	@GetMapping("/micas")
	public ModelAndView viewMicas() {
		
		return viewInventario.inventarioProducto(getUsuario(),2,VIEW_MICA);
	}
	
	
	@GetMapping("/insumos")
	public ModelAndView viewInsumos() {
		
		return viewInventario.inventarioProducto(getUsuario(),3,VIEW_INSUMO);
	}
	
	@PostMapping(path = "/guardar/armazon")
	public ModelAndView registrarArmazon(@ModelAttribute ProductoDto producto ) {
		//ResponseGeneric respuesta=inventarioService.actualizarStockProducto(stockProducto, getUsuario());
		return catalogoService.registroProducto( getUsuario(),producto,VIEW_ARMAZON);
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
