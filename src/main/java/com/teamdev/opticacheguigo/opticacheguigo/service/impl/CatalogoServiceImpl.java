package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;


import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
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
	 
	 @Autowired
	 Util util;
	 
	 
	 
	 private static final String ERROR_INSERT="OCURRI&Oacute; UN ERROR AL REGISTRAR EL PRODUCTO";

	@Override
	public ResponseGeneric registrarProducto(ProductoDto producto, AuthHeader userSession) {
		String result = util.callRestPostAuth(producto,urlRegistrarProducto,userSession);
		return (result.equals("ERROR")?new ResponseGeneric(0,ERROR_INSERT,new Date(),1):(ResponseGeneric) util.jsonToObject(new ResponseGeneric(), result));
		 
	}

	@Override
	public ProductoDto converToMayus(ProductoDto producto) {
		ProductoDto convertProducto= new ProductoDto();
		convertProducto.setIdCategoria(producto.getIdCategoria());
		convertProducto.setIdMaterial(producto.getIdMaterial());
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

	

}
