package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.MicaDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;
import com.teamdev.opticacheguigo.opticacheguigo.service.CatalogoService;
import com.teamdev.opticacheguigo.opticacheguigo.service.ViewsCatalogoService;
import com.teamdev.opticacheguigo.opticacheguigo.service.ViewsInventarioService;

@Service
public class ViewsCatalogoServiceImpl implements ViewsCatalogoService {

	@Autowired
	InventarioServiceImpl inventarioService;
	
	@Autowired
	CatalogoService catalogoService;
	
	private static final String VIEW_ARMAZON="catalogoArmazon";
	private static final String VIEW_MICA="catalogoMica";
	private static final String VIEW_INSUMO="catalogoInsumo";
	
	public ModelAndView inventarioProducto(AuthHeader userSesion, Integer idCategoria,String view) {
		
		return new ModelAndView(view).addObject("productos", inventarioService.productsByCatgory(idCategoria,1, userSesion));
	}


	@Override
	public ModelAndView registroProducto(AuthHeader userSession, ProductoDto producto, String view) {
		ModelAndView vistaRegistroPro;
		String vista=null;
		if(view.equals(VIEW_ARMAZON)) {
			producto.setIdCategoria(1);
			vista=VIEW_ARMAZON;
		} 
		
		if(view.equals(VIEW_MICA)) {
			producto.setIdCategoria(2);
			vista=VIEW_MICA;
		}
		
		if(view.equals(VIEW_INSUMO)) {
			producto.setIdCategoria(3);
			vista=VIEW_INSUMO;
			
		}
		vistaRegistroPro=new ModelAndView(vista);
		producto = catalogoService.converToMayus(producto);
		ResponseGeneric responseAlta= catalogoService.registrarProducto(producto, userSession);
		vistaRegistroPro.addObject("codOperacion",responseAlta.getCodigo())
		.addObject("mensaje", responseAlta.getMensaje())
		.addObject("productoError",producto)
		.addObject("productos", inventarioService.productsByCatgory(producto.getIdCategoria(),1, userSession));
		
		
		
		return vistaRegistroPro;
	}

	
	@Override
	public ModelAndView actualizaProducto(AuthHeader userSession, ProductoDto producto, String view) {
		ModelAndView vistaRegistroPro;
		String vista=null;
		if(view.equals(VIEW_ARMAZON)) {
			producto.setIdCategoria(1);
			vista=VIEW_ARMAZON;
		} 
		
		if(view.equals(VIEW_MICA)) {
			producto.setIdCategoria(2);
			vista=VIEW_MICA;
		}
		
		if(view.equals(VIEW_INSUMO)) {
			producto.setIdCategoria(3);
			vista=VIEW_INSUMO;
			
		}
		vistaRegistroPro=new ModelAndView(vista);
		producto = catalogoService.converToMayus(producto);
		ResponseGeneric responseAlta= catalogoService.actualizarProducto(producto, userSession);
		vistaRegistroPro.addObject("codOperacion",responseAlta.getCodigo())
		.addObject("mensaje", responseAlta.getMensaje())
		.addObject("productoError",producto)
		.addObject("productos", inventarioService.productsByCatgory(producto.getIdCategoria(),1, userSession));
		
		
		
		return vistaRegistroPro;
	}


	@Override
	public ModelAndView actualizaMica(AuthHeader userSesion, MicaDto mica) {
		ModelAndView vistaRegistroPro;
		vistaRegistroPro=new ModelAndView(VIEW_MICA);
		mica = catalogoService.converToMayusMica(mica);
		ResponseGeneric responseAlta= catalogoService.actualizarMica(mica, userSesion);
		vistaRegistroPro.addObject("codOperacion",responseAlta.getCodigo())
		.addObject("mensaje", responseAlta.getMensaje())
		.addObject("productoError",mica)
		.addObject("micas", inventarioService.micasByMaterial(0, 1, userSesion))
		.addObject("micasEliminadas", inventarioService.micasByMaterial(0, 0, userSesion))
		.addObject("materiales", inventarioService.getMateriales(userSesion));
		
		
		
		return vistaRegistroPro;
	}


	@Override
	public ModelAndView registroMica(AuthHeader userSesion, MicaDto mica) {
		ModelAndView vistaRegistroPro;
		vistaRegistroPro=new ModelAndView(VIEW_MICA);
		mica = catalogoService.converToMayusMica(mica);
		ResponseGeneric responseAlta= catalogoService.registraMica(mica, userSesion);
		vistaRegistroPro.addObject("codOperacion",responseAlta.getCodigo())
		.addObject("mensaje", responseAlta.getMensaje())
		.addObject("productoError",mica)
		.addObject("micas", inventarioService.micasByMaterial(0, 1, userSesion))
		.addObject("micasEliminadas", inventarioService.micasByMaterial(0, 0, userSesion))
		.addObject("materiales", inventarioService.getMateriales(userSesion));
		
		
		
		return vistaRegistroPro;
	}
	

}
