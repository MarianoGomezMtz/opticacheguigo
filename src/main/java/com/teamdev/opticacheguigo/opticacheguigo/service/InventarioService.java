package com.teamdev.opticacheguigo.opticacheguigo.service;

import java.util.List;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.StockProducto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ConsultaMicas;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.MaterialDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;




public interface InventarioService {
	List<ProductoDto> productsByCatgory(Integer idCategory,AuthHeader userSession);
	List<ConsultaMicas>micasByMaterial(Integer idMaterial,Integer estatus,AuthHeader userSession);
	ResponseGeneric actualizarStockProducto(StockProducto stockProducto,AuthHeader userSession);
	ProductoDto detalleProducto(String idProducto,AuthHeader userSession);
	List<MaterialDto> getMateriales(AuthHeader userSession);
	ConsultaMicas detailMica(String idMica,AuthHeader userSession);
}
