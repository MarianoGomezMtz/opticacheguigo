package com.teamdev.opticacheguigo.opticacheguigo.dto.response;

import java.util.Date;

public class ResponseGeneric {
	
		private int codigo;
		private String mensaje;
		private Date fechaOperacion;
		private int idUser;
		
		public ResponseGeneric() {
			
		}

	public ResponseGeneric(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

		public ResponseGeneric(int codigo, String mensaje, Date fechaOperacion, int idUser) {
			this.codigo = codigo;
			this.mensaje = mensaje;
			this.fechaOperacion = fechaOperacion;
			this.idUser = idUser;
		}

		public int getCodigo() {
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}

		public String getMensaje() {
			return mensaje;
		}

		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}

		public Date getFechaOperacion() {
			return fechaOperacion;
		}

		public void setFechaOperacion(Date fechaOperacion) {
			this.fechaOperacion = fechaOperacion;
		}

		public int getIdUser() {
			return idUser;
		}

		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}
		
		
		
		
						
}
