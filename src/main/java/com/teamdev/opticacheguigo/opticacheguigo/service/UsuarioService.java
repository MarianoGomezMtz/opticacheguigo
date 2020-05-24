package com.teamdev.opticacheguigo.opticacheguigo.service;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.UsuarioPassEncrypt;

public interface UsuarioService {
	UsuarioPassEncrypt passEncryp(String username);
}
