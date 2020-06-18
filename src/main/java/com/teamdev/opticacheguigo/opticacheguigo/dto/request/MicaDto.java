package com.teamdev.opticacheguigo.opticacheguigo.dto.request;
public class MicaDto {
	
		private Integer id;
		private String nombre;
		private String descripcion;
		private String estatus;
		private String fecha;
		private Integer idMaterial;
		private Double precio;
		private Double precioVenta;
		
		public MicaDto() {
			
		}

		public MicaDto(Integer id, String nombre, String descripcion, String estatus, String fecha, Integer idMaterial,
				Double precio, Double precioVenta) {
			
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.estatus = estatus;
			this.fecha = fecha;
			this.idMaterial = idMaterial;
			this.precio = precio;
			this.precioVenta = precioVenta;
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

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getEstatus() {
			return estatus;
		}

		public void setEstatus(String estatus) {
			this.estatus = estatus;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}

		public Integer getIdMaterial() {
			return idMaterial;
		}

		public void setIdMaterial(Integer idMaterial) {
			this.idMaterial = idMaterial;
		}

		public Double getPrecio() {
			return precio;
		}

		public void setPrecio(Double precio) {
			this.precio = precio;
		}

		public Double getPrecioVenta() {
			return precioVenta;
		}

		public void setPrecioVenta(Double precioVenta) {
			this.precioVenta = precioVenta;
		}
						
			
}
