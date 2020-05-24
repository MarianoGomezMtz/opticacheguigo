package com.teamdev.opticacheguigo.opticacheguigo.dto.response;

public class ProductoDto {
	
	private Integer  id;
	private String  clave;
	private String  nombre;
	private String  tipo;
	private Integer  existencia;
	private Double  precioCompra;
	private Double  precioVenta;
	private String  color;
	private String  modelo;
	private Integer  status;
	private String  tamanio;
	private Integer  idCategoria;
	private Integer  idMaterial;
	private String categoria;
	private String material;
		
	public ProductoDto() {
		
	}
	
	

	public ProductoDto(Integer id, String clave, String nombre, String tipo, Integer existencia, Double precioCompra,
			Double precioVenta, String color, String modelo, Integer status, String tamanio, Integer idCategoria,
			Integer idMaterial, String categoria, String material) {
		this.id = id;
		this.clave = clave;
		this.nombre = nombre;
		this.tipo = tipo;
		this.existencia = existencia;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.color = color;
		this.modelo = modelo;
		this.status = status;
		this.tamanio = tamanio;
		this.idCategoria = idCategoria;
		this.idMaterial = idMaterial;
		this.categoria=categoria;
		this.material=material;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getExistencia() {
		return existencia;
	}

	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}

	public Double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Integer getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}
		
	
	
}
