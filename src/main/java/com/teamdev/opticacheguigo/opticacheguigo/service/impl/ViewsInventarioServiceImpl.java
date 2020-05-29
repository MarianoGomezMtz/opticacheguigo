package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.service.ViewsInventarioService;

@Service
public class ViewsInventarioServiceImpl implements ViewsInventarioService {

	@Autowired
	InventarioServiceImpl inventarioService;
	
	
	public ModelAndView inventarioProducto(AuthHeader userSesion, Integer idCategoria,String view) {
		
		return new ModelAndView(view).addObject("productos", inventarioService.productsByCatgory(idCategoria, userSesion));
	}

	/*
	@Override
	public ModelAndView inventarioMica(AuthHeader userSesion) {
		return new ModelAndView("gestionMicas").addObject("productos", inventarioService.productsByCatgory(2, userSesion));
	}

	@Override
	public ModelAndView inventarioInsumo(AuthHeader userSesion) {
		return new ModelAndView("gestionInsumo").addObject("productos", inventarioService.productsByCatgory(3, userSesion));
	}
	*/

}
