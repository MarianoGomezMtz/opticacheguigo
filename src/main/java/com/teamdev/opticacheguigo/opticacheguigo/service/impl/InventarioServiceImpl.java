package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.service.InventarioService;

@Service
public class InventarioServiceImpl implements InventarioService {

	 @Value("${productoCategoria}")
	 private String urlProductocategoria;

	@Override
	public List<ProductoDto> productsByCatgory(Integer idCategory) {
		// TODO Auto-generated method stub
		return null;
	}
	
	



}
