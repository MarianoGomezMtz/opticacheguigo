package com.teamdev.opticacheguigo.opticacheguigo.dto.response;

public class MaterialDto {
	private Long id;
	private String nombre;
	private Long  estatus;
	private String fechaCreacion;
		
	public MaterialDto() {
		
	}

	public MaterialDto(Long id, String nombre, Long estatus, String fechaCreacion) {
		this.id = id;
		this.nombre = nombre;
		this.estatus = estatus;
		this.fechaCreacion = fechaCreacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public Long getEstatus() {
		return estatus;
	}

	public void setEstatus(Long estatus) {
		this.estatus = estatus;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	
	
	

}
