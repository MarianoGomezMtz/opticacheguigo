package com.teamdev.opticacheguigo.opticacheguigo.dto.request;

public class UsuarioPassEncrypt {
	
	private String passEncrypt;
	
	
	public UsuarioPassEncrypt() {
		
	}
	
	public UsuarioPassEncrypt(String passEncrypt) {
		this.passEncrypt = passEncrypt;
	}
	
	public String getPassEncrypt() {
		return passEncrypt;
	}


	public void setPassEncrypt(String passEncrypt) {
		this.passEncrypt = passEncrypt;
	}
	

}
