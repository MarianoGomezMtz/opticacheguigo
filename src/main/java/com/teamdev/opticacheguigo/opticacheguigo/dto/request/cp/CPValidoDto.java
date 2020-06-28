package com.teamdev.opticacheguigo.opticacheguigo.dto.request.cp;
public class CPValidoDto {
	private String codigoPostal;
	private String asentamiento;
	private String municipio;
	private String estado;
			
	public CPValidoDto() {
		
	}

	public CPValidoDto(String codigoPostal, String asentamiento, String municipio, String estado) {
		this.codigoPostal = codigoPostal;
		this.asentamiento = asentamiento;
		this.municipio = municipio;
		this.estado = estado;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getAsentamiento() {
		return asentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
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
			
}
