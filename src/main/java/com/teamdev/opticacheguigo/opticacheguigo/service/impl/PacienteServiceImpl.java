package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.UsuarioPassEncrypt;
import com.teamdev.opticacheguigo.opticacheguigo.service.PacienteService;
import com.teamdev.opticacheguigo.opticacheguigo.service.UsuarioService;

@Service
public class PacienteServiceImpl implements PacienteService{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	

}
