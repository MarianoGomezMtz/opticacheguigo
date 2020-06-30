package com.teamdev.opticacheguigo.opticacheguigo.service;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.AuthHeader;
import com.teamdev.opticacheguigo.opticacheguigo.dto.request.ClienteDto;
import com.teamdev.opticacheguigo.opticacheguigo.dto.response.ResponseGeneric;

public interface PacienteService {
	ResponseGeneric guardarPaciente(ClienteDto paciente,AuthHeader userSession);
	ClienteDto converToMayus(ClienteDto paciente);
	
}
