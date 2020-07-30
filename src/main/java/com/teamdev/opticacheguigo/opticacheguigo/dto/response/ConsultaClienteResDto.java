package com.teamdev.opticacheguigo.opticacheguigo.dto.response;

public class ConsultaClienteResDto {
	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	private Integer  estatus;
	private String fechaCreacion;
	
	
		
	public ConsultaClienteResDto() {
		
	}



	public ConsultaClienteResDto(Integer id, String nombre, String direccion, String telefono, String email,
			Integer estatus, String fechaCreacion) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.estatus = estatus;
		this.fechaCreacion = fechaCreacion;
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



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Integer getEstatus() {
		return estatus;
	}



	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}



	public String getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	

	
		

}
