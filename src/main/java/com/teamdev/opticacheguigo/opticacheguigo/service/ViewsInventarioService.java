package com.teamdev.opticacheguigo.opticacheguigo.service;

import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;

public interface ViewsInventarioService {
	public ModelAndView inventarioProducto(AuthHeader userSesion,Integer idCategoria,String view);
	

}
