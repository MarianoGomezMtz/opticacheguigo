package com.teamdev.opticacheguigo.opticacheguigo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teamdev.opticacheguigo.opticacheguigo.dto.request.UsuarioPassEncrypt;
import com.teamdev.opticacheguigo.opticacheguigo.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public UsuarioPassEncrypt passEncryp(String username) {
		BCryptPasswordEncoder bCryp =new BCryptPasswordEncoder();
		String sql="SELECT  password as passEncrypt FROM usuarios WHERE email =? and status=1";
		UsuarioPassEncrypt passEncryp = (UsuarioPassEncrypt) jdbcTemplate.queryForObject(sql, new Object[]{username},
	            BeanPropertyRowMapper.newInstance(UsuarioPassEncrypt.class));
		System.out.println("Alternativa: "+BCrypt.hashpw(passEncryp.getPassEncrypt(), BCrypt.gensalt()));
		
		return passEncryp;
	}

}
