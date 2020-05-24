package com.teamdev.opticacheguigo.opticacheguigo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;




public interface InventarioService {
	List<ProductoDto> productsByCatgory(Integer idCategory,AuthHeader userSession);
}
