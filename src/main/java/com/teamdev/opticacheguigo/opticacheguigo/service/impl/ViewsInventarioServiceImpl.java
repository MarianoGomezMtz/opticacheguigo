package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.service.ViewsInventarioService;

@Service
public class ViewsInventarioServiceImpl implements ViewsInventarioService {

	
	
	@Override
	public ModelAndView inventarioArmazon() {
		
		return new ModelAndView("gestionArmazon");
	}

	@Override
	public ModelAndView inventarioMica() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelAndView inventarioInsumo() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
