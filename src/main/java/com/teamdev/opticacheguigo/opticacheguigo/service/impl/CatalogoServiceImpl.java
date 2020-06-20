package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;


import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.MicaDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.StockProducto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;
import com.teamdev.opticacheguigo.opticacheguigo.service.CatalogoService;
import com.teamdev.opticacheguigo.opticacheguigo.service.InventarioService;
import com.teamdev.opticacheguigo.opticacheguigo.service.Util;




@Service
public class CatalogoServiceImpl implements CatalogoService {

	 @Value("${productoCategoria}")
	 private String urlProductoCategoria;
	 
	 @Value("${actualizaStock}")
	 private String urlActualizaStock;
	 
	 @Value("${registrarProducto}")
	 private String urlRegistrarProducto;
	 
	 @Value("${registrarMica}")
	 private String urlRegistrarMica;
	 
	 
	 @Value("${actualizaProducto}")
	 private String urlActualizarProducto;
	 
	 @Value("${actualizaMica}")
	 private String urlActualizaMica;
	 
	 
	 @Value("${eliminaProducto}")
	 private String urlEliminarProducto;
	 
	 @Value("${eliminaMica}")
	 private String urlEliminaMica;
	 
	 
	 
	 @Autowired
	 Util util;
	 
	 
	 
	 private static final String ERROR_INSERT="OCURRIO UN ERROR AL REGISTRAR";
	 private static final String ERROR_UPDATE="OCURRIO UN ERROR AL ACTUALIZAR";
	 private static final String ERROR_DELETE="OCURRIO UN ERROR AL ELIMINAR";

	@Override
	public ResponseGeneric registrarProducto(ProductoDto producto, AuthHeader userSession) {
		String result = util.callRestPostAuth(producto,urlRegistrarProducto,userSession);
		return (result.equals("ERROR")?new ResponseGeneric(0,ERROR_INSERT,new Date(),1):(ResponseGeneric) util.jsonToObject(new ResponseGeneric(), result));
		 
	}

	@Override
	public ProductoDto converToMayus(ProductoDto producto) {
		ProductoDto convertProducto= new ProductoDto();
		convertProducto.setId(producto.getId()==null?null:producto.getId());
		convertProducto.setIdCategoria(producto.getIdCategoria());
		convertProducto.setExistencia(producto.getExistencia());
		convertProducto.setPrecioCompra(producto.getPrecioCompra());
		convertProducto.setPrecioVenta(producto.getPrecioVenta());
		convertProducto.setClave(producto.getClave()==null?producto.getClave():producto.getClave().toUpperCase());
		convertProducto.setColor(producto.getColor()==null||producto.getColor().equals("")?producto.getColor():producto.getColor().toUpperCase());
		convertProducto.setModelo(producto.getModelo()==null?producto.getModelo():producto.getModelo().toUpperCase());
		convertProducto.setNombre(producto.getNombre()==null?producto.getNombre():producto.getNombre().toUpperCase());
		convertProducto.setTipo(producto.getTipo()==null?producto.getTipo():producto.getTipo().toUpperCase());
		convertProducto.setTamanio(producto.getTamanio()==null?producto.getTamanio():producto.getTamanio().toUpperCase());
		
		// TODO Auto-generated method stub
		return convertProducto;
	}

	@Override
	public ResponseGeneric eliminarProducto(String idProducto, AuthHeader userSession) {
		String result="ERROR";
		try {
			result = util.sendGetAuth(urlEliminarProducto+idProducto,userSession);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (result.equals("ERROR")?new ResponseGeneric(0,ERROR_DELETE,new Date(),1):(ResponseGeneric) util.jsonToObject(new ResponseGeneric(), result));
	}

	@Override
	public ResponseGeneric actualizarProducto(ProductoDto producto, AuthHeader userSession) {
		String result = util.callRestPostAuth(producto,urlActualizarProducto,userSession);
		return (result.equals("ERROR")?new ResponseGeneric(0,ERROR_UPDATE,new Date(),1):(ResponseGeneric) util.jsonToObject(new ResponseGeneric(), result));
		
	}

	@Override
	public ResponseGeneric eliminarMica(String idMica, AuthHeader userSession) {
		String result="ERROR";
		try {
			result = util.sendGetAuth(urlEliminaMica+idMica,userSession);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (result.equals("ERROR")?new ResponseGeneric(0,ERROR_DELETE,new Date(),1):(ResponseGeneric) util.jsonToObject(new ResponseGeneric(), result));
	
	}

	@Override
	public MicaDto converToMayusMica(MicaDto mica) {
		mica.setId(mica.getId()==null?null:mica.getId());
		mica.setDescripcion(mica.getDescripcion()==null?"":mica.getDescripcion().toUpperCase());
		mica.setIdMaterial(mica.getIdMaterial());
		mica.setNombre(mica.getNombre()==null?"":mica.getNombre().toUpperCase());
		
		return mica;
	}

	@Override
	public ResponseGeneric actualizarMica(MicaDto mica, AuthHeader userSession) {
		String result = util.callRestPostAuth(mica,urlActualizaMica,userSession);
		return (result.equals("ERROR")?new ResponseGeneric(0,ERROR_UPDATE,new Date(),1):(ResponseGeneric) util.jsonToObject(new ResponseGeneric(), result));
	}
	
	@Override
	public ResponseGeneric registraMica(MicaDto mica, AuthHeader userSession) {
		String result = util.callRestPostAuth(mica,urlRegistrarMica,userSession);
		return (result.equals("ERROR")?new ResponseGeneric(0,ERROR_UPDATE,new Date(),1):(ResponseGeneric) util.jsonToObject(new ResponseGeneric(), result));
	}

	

}
