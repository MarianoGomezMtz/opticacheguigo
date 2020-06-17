package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;


import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.StockProducto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ConsultaMicas;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.MaterialDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;
import com.teamdev.opticacheguigo.opticacheguigo.service.InventarioService;
import com.teamdev.opticacheguigo.opticacheguigo.service.Util;




@Service
public class InventarioServiceImpl implements InventarioService {

	 @Value("${productoCategoria}")
	 private String urlProductoCategoria;
	 
	 @Value("${actualizaStock}")
	 private String urlActualizaStock;
	 
	 @Value("${detailProducto}")
	 private String urlDetalleProducto;
	 
	 @Value("${listaMicaMaterial}")
	 private String urlListaMicaMaterial;
	 
	 @Value("${listaMaterial}")
	 private String urlListaMaterial;
	 
	 @Autowired
	 Util util;

	@Override
	public List<ProductoDto> productsByCatgory(Integer idCategory,AuthHeader userSession) {
		String url =urlProductoCategoria+idCategory;
		String result=null;
		try {
			 result = util.sendGetAuth(url, userSession);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		//List<ProductoDto> productos =util.arrayJsonToList(result);
		//System.out.println(productos.get(0).getColor());
		
		return (result.equals("ERROR")?new ArrayList<>():util.arrayJsonToList(result));
	}

	@Override
	public ResponseGeneric actualizarStockProducto(StockProducto stockProducto,AuthHeader userSession) {
		String url =urlActualizaStock+stockProducto.getIdProducto()+"/"+stockProducto.getIdCategoria()+"/"+stockProducto.getCantidad();
		String result=null;
		try {
			 result = util.sendGetAuth(url, userSession);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ResponseGeneric) util.jsonToObject(new ResponseGeneric(), result);
		//return respuesta;
	}

	@Override
	public ProductoDto detalleProducto(String idProducto, AuthHeader userSession) {
		String url =urlDetalleProducto+idProducto;
		String result=null;
		try {
			 result = util.sendGetAuth(url, userSession);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ProductoDto) util.jsonToObject(new ProductoDto(), result);
		
	}

	@Override
	public List<MaterialDto> getMateriales(AuthHeader userSession) {
		String url =urlListaMaterial;
		String result=null;
		try {
			 result = util.sendGetAuth(url, userSession);
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return (result.equals("ERROR")?new ArrayList<>():util.arrayJsonToListMat(result));
	}

	@Override
	public List<ConsultaMicas> micasByMaterial(Integer idMaterial, Integer estatus, AuthHeader userSession) {
		String url =urlListaMicaMaterial+idMaterial+"/"+estatus;
		String result=null;
		try {
			 result = util.sendGetAuth(url, userSession);
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		return (result.equals("ERROR")?new ArrayList<>():util.arrayJsonToListMica(result));
	}
	
	



}
