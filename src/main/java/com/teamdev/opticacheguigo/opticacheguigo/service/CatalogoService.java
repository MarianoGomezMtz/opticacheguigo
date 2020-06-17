package com.teamdev.opticacheguigo.opticacheguigo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.StockProducto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;

public interface CatalogoService {
	ResponseGeneric registrarProducto(ProductoDto producto,AuthHeader userSession);
	ResponseGeneric actualizarProducto(ProductoDto producto,AuthHeader userSession);
	ResponseGeneric eliminarProducto(String idProducto,AuthHeader userSession);
	ResponseGeneric eliminarMica(String idMica,AuthHeader userSession);
	ProductoDto converToMayus(ProductoDto producto);
	
}
