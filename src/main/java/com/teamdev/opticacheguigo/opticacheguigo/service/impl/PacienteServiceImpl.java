package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.ClienteDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.ConsultaClienteDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ConsultaClienteResDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ProductoDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;
import com.teamdev.opticacheguigo.opticacheguigo.service.PacienteService;
import com.teamdev.opticacheguigo.opticacheguigo.service.Util;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	 @Value("${registrarPaciente}")
	 private String urlRegistrarPaciente;
	 
	 @Value("${consultarPaciente}")
	 private String urlConsultarPaciente;
	 
	 
		
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

		paciente.setId(paciente.getId()==null?null:paciente.getId());
		paciente.setNombre(paciente.getNombre()==null?null:paciente.getNombre().toUpperCase());
		paciente.setApPaterno(paciente.getApPaterno()==null?null:paciente.getApPaterno().toUpperCase());
		paciente.setApMaterno(paciente.getApMaterno()==null?null:paciente.getApMaterno().toUpperCase());
		paciente.setColonia(paciente.getColonia()==null?null:paciente.getColonia().toUpperCase());
		paciente.setMunicipio(paciente.getMunicipio()==null?null:paciente.getMunicipio().toUpperCase());
		paciente.setEstado(paciente.getEstado()==null?null:paciente.getEstado().toUpperCase());
		paciente.setCalle(paciente.getCalle()==null?null:paciente.getCalle().toUpperCase());
		paciente.setTelefono(paciente.getTelefono()==null?null:paciente.getTelefono());
		paciente.setEmail(paciente.getEmail()==null?null:paciente.getEmail());
		return paciente;
	}

	@Override
	public ConsultaClienteDto convertConsultToMayus(ConsultaClienteDto paciente) {
		paciente.setId(paciente.getId()==null?0:paciente.getId());
		paciente.setNombre(paciente.getNombre()==null||paciente.getNombre().equals("")?"0":paciente.getNombre().toUpperCase());
		paciente.setApPaterno(paciente.getApPaterno()==null||paciente.getApPaterno().equals("")?"0":paciente.getApPaterno().toUpperCase());
		paciente.setApMaterno(paciente.getApMaterno()==null||paciente.getApMaterno().equals("")?"0":paciente.getApMaterno().toUpperCase());
		paciente.setEmail(paciente.getEmail()==null||paciente.getEmail().equals("")?null:paciente.getEmail());
		paciente.setEstatus(paciente.getEstatus()==null?0:paciente.getEstatus());
		return paciente;
	}

	@Override
	public List<ConsultaClienteResDto> consultaPacientes(ConsultaClienteDto consultaPaciente,AuthHeader user) {
		String result=null;
		result = util.callRestPostAuth(consultaPaciente,urlConsultarPaciente, user);
				
		return (result.equals("ERROR")?new ArrayList<>():util.arrayJsonToListPaciente(result));
		
	}

	

}
