package com.teamdev.opticacheguigo.opticacheguigo.service;

import com.teamdev.opticacheguigo.opticacheguigo.dto.response.MaterialDto;
import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.MicaDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;

public interface ViewsCatalogoService {
	ModelAndView registroProducto(AuthHeader userSesion,ProductoDto prodcuto,String view);
	ModelAndView registroMica(AuthHeader userSesion,MicaDto mica);
	ModelAndView actualizaProducto(AuthHeader userSesion,ProductoDto prodcuto,String view);
	ModelAndView actualizaMica(AuthHeader userSesion,MicaDto mica);

	ModelAndView registroBaseMaterial(AuthHeader userSession, MaterialDto producto, String view);

    ModelAndView actualizarBaseMaterial(MaterialDto producto, AuthHeader userSession, String view);
}
