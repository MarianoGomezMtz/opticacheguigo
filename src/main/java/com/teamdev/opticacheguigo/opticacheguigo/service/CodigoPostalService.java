package com.teamdev.opticacheguigo.opticacheguigo.service;

import java.util.List;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.StockProducto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.cp.CPValidoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ConsultaMicas;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.MaterialDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;




public interface CodigoPostalService {
	List<CPValidoDto> getListCP(String cp);
	
}
