package com.teamdev.opticacheguigo.opticacheguigo.dto.request;

public class StockProducto {
	private String idProducto;
	private String idCategoria;
	private String cantidad;
	
	
    public StockProducto() {
		
	}

    

	public StockProducto(String idProducto, String idCategoria, String cantidad) {
		
		this.idProducto = idProducto;
		this.idCategoria = idCategoria;
		this.cantidad = cantidad;
	}



	public String getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}


	public String getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	
	
}
