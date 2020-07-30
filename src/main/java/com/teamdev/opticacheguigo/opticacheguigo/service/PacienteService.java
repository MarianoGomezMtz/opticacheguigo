package com.teamdev.opticacheguigo.opticacheguigo.service;

import java.util.List;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.ClienteDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.ConsultaClienteDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ConsultaClienteResDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;

public interface PacienteService {
	ResponseGeneric guardarPaciente(ClienteDto paciente,AuthHeader userSession);
	ClienteDto converToMayus(ClienteDto paciente);
	ConsultaClienteDto convertConsultToMayus(ConsultaClienteDto consultaPaciente);
	List<ConsultaClienteResDto> consultaPacientes(ConsultaClienteDto consultaPaciente,AuthHeader user);
	
	
}
