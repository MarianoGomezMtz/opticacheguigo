package com.teamdev.opticacheguigo.opticacheguigo.service;

import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.MicaDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;

public interface ViewsCatalogoService {
	public ModelAndView registroProducto(AuthHeader userSesion,ProductoDto prodcuto,String view);
	public ModelAndView registroMica(AuthHeader userSesion,MicaDto mica);
	public ModelAndView actualizaProducto(AuthHeader userSesion,ProductoDto prodcuto,String view);
	public ModelAndView actualizaMica(AuthHeader userSesion,MicaDto mica);

}
