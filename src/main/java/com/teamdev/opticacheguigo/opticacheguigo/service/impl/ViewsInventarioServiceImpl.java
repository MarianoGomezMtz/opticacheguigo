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
	
	@Override
	public ModelAndView inventarioArmazon(AuthHeader userSesion) {
		
		return new ModelAndView("gestionArmazon").addObject("productos", inventarioService.productsByCatgory(1, userSesion));
	}

	@Override
	public ModelAndView inventarioMica(AuthHeader userSesion) {
		return new ModelAndView("gestionMicas").addObject("productos", inventarioService.productsByCatgory(2, userSesion));
	}

	@Override
	public ModelAndView inventarioInsumo(AuthHeader userSesion) {
		return new ModelAndView("gestionInsumo").addObject("productos", inventarioService.productsByCatgory(3, userSesion));
	}
	

}
