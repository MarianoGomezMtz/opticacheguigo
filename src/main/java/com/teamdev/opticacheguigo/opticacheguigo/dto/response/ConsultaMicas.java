package com.teamdev.opticacheguigo.opticacheguigo.dto.response;
public class ConsultaMicas {
	
		private int id;
		private String nombre;
		private String descripcion;
		private String estatus;
		private String fecha;
		private int idMaterial;
		private double precio;
		private double precioVenta;
		private String material;
	
		
		
		public ConsultaMicas() {
			
		}

		public ConsultaMicas(int id, String nombre, String descripcion, String estatus, String fecha, int idMaterial,
				double precio, double precioVenta, String material) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.estatus = estatus;
			this.fecha = fecha;
			this.idMaterial = idMaterial;
			this.precio = precio;
			this.precioVenta = precioVenta;
			this.material = material;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
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

		public int getIdMaterial() {
			return idMaterial;
		}

		public void setIdMaterial(int idMaterial) {
			this.idMaterial = idMaterial;
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public double getPrecioVenta() {
			return precioVenta;
		}

		public void setPrecioVenta(double precioVenta) {
			this.precioVenta = precioVenta;
		}

		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}
		
			
}
