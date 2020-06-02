package com.teamdev.opticacheguigo.opticacheguigo.service;

import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;

public interface ViewsCatalogoService {
	public ModelAndView registroProducto(AuthHeader userSesion,ProductoDto prodcuto,String view);
	

}
