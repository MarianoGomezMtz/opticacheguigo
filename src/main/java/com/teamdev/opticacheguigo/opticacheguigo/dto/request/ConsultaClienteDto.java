package com.teamdev.opticacheguigo.opticacheguigo.dto.request;

public class ConsultaClienteDto {
	private Integer id;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private Integer  estatus;
	private String email;
	
	
		
	public ConsultaClienteDto() {
		
	}


	public ConsultaClienteDto(Integer id, String nombre, String apPaterno, String apMaterno, Integer estatus, String email) {
		
		this.id = id;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.estatus = estatus;
		this.email = email;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApPaterno() {
		return apPaterno;
	}


	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}


	public String getApMaterno() {
		return apMaterno;
	}


	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}


	public Integer getEstatus() {
		return estatus;
	}


	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}




}
