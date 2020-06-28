package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.cp.CPValidoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.service.CodigoPostalService;
import com.teamdev.opticacheguigo.opticacheguigo.service.Util;



@Service
public class CodigoPostalServiceImpl implements CodigoPostalService {

	 @Value("${getCodigoPostal}")
	 private String urlGetCodigoPostal;
	 
	 
	 
	 @Autowired
	 Util util;

	@Override
	public List<CPValidoDto> getListCP(String cp) {
		
		String url =urlGetCodigoPostal+cp;
		String result=null;
		try {
			 result = util.sendGET(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
				
		return (result.equals("ERROR")?new ArrayList<>():util.arrayJsonToListCP(result));
	}

}
