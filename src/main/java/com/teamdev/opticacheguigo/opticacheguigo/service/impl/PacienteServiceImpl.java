package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.ClienteDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;
import com.teamdev.opticacheguigo.opticacheguigo.service.PacienteService;
import com.teamdev.opticacheguigo.opticacheguigo.service.Util;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	 @Value("${registrarPaciente}")
	 private String urlRegistrarPaciente;
		
	 @Autowired
	 Util util;
	 
	 private static final String ERROR_INSERT="OCURRIO UN ERROR AL REGISTRAR";
	 private static final String ERROR_UPDATE="OCURRIO UN ERROR AL ACTUALIZAR";
	 private static final String ERROR_DELETE="OCURRIO UN ERROR AL ELIMINAR";

	@Override
	public ResponseGeneric guardarPaciente(ClienteDto paciente,AuthHeader userSession) {
		String result = util.callRestPostAuth(paciente,urlRegistrarPaciente,userSession);
		return (result.equals("ERROR")?new ResponseGeneric(0,ERROR_INSERT,new Date(),1):
			(ResponseGeneric) util.jsonToObject(new ResponseGeneric(), result));
		
	}
	
	@Override
	public ClienteDto converToMayus(ClienteDto paciente) {
//		String rawString = "Entwickeln Sie mit Vergnügen";
//		byte[] bytes = rawString.getBytes(StandardCharsets.UTF_8);
//		 
//		String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
		paciente.setId(paciente.getId()==null?null:paciente.getId());
		paciente.setNombre(paciente.getNombre()==null?null:paciente.getNombre().toUpperCase());
		paciente.setApPaterno(paciente.getApPaterno()==null?null:paciente.getApPaterno().toUpperCase());
		paciente.setApMaterno(paciente.getApMaterno()==null?null:paciente.getApMaterno().toUpperCase());
		paciente.setColonia(paciente.getColonia()==null?null:new String(paciente.getColonia().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8).toUpperCase());
		paciente.setMunicipio(paciente.getMunicipio()==null?null:new String(paciente.getMunicipio().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8).toUpperCase());
		paciente.setEstado(paciente.getEstado()==null?null:new String(paciente.getEstado().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8).toUpperCase());
		paciente.setCalle(paciente.getCalle()==null?null:new String(paciente.getCalle().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8).toUpperCase());
		paciente.setTelefono(paciente.getTelefono()==null?null:paciente.getTelefono());
		paciente.setEmail(paciente.getEmail()==null?null:paciente.getEmail());
		return paciente;
	}

	

}
