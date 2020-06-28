package com.teamdev.opticacheguigo.opticacheguigo.dto.request;

public class ClienteDto {
	private Integer id;
	private String nombre;
	private String apPaterno;
	private String apMaterno;
	private Integer  estatus;
	private String email;
	private String telefono;
	private String foto;
	private String fechaCreacion;
	private String codigoPostal;
	private String colonia;
	private String municipio;
	private String estado;
	private String calle;
	private String numExterior;
	private String numInterior;
	
		
	public ClienteDto() {
		
	}


	public ClienteDto(Integer id, String nombre, String apPaterno, String apMaterno, Integer estatus, String email,
			String telefono, String foto, String fechaCreacion, String codigoPostal, String colonia, String municipio,
			String estado, String calle, String numExterior, String numInterior) {
		
		this.id = id;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.estatus = estatus;
		this.email = email;
		this.telefono = telefono;
		this.foto = foto;
		this.fechaCreacion = fechaCreacion;
		this.codigoPostal = codigoPostal;
		this.colonia = colonia;
		this.municipio = municipio;
		this.estado = estado;
		this.calle = calle;
		this.numExterior = numExterior;
		this.numInterior = numInterior;
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


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public String getColonia() {
		return colonia;
	}


	public void setColonia(String colonia) {
		this.colonia = colonia;
	}


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getNumExterior() {
		return numExterior;
	}


	public void setNumExterior(String numExterior) {
		this.numExterior = numExterior;
	}


	public String getNumInterior() {
		return numInterior;
	}


	public void setNumInterior(String numInterior) {
		this.numInterior = numInterior;
	}
	
	
	
	
	
	
	

}
