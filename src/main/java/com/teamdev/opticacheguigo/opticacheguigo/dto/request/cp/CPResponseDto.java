package com.teamdev.opticacheguigo.opticacheguigo.dto.request.cp;

public class CPResponseDto {
	 
	 private String cp;
	 private String asentamiento;
	 private String tipo_asentamiento;
	 private String municipio;
	 private String estado;
	 private String ciudad;
	 private String pais;
	
	 public CPResponseDto(String cp, String asentamiento, String tipo_asentamiento, String municipio, String estado,
			String ciudad, String pais) {

		this.cp = cp;
		this.asentamiento = asentamiento;
		this.tipo_asentamiento = tipo_asentamiento;
		this.municipio = municipio;
		this.estado = estado;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public CPResponseDto() {
		
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getAsentamiento() {
		return asentamiento;
	}

	public void setAsentamiento(String asentamiento) {
		this.asentamiento = asentamiento;
	}

	public String getTipo_asentamiento() {
		return tipo_asentamiento;
	}

	public void setTipo_asentamiento(String tipo_asentamiento) {
		this.tipo_asentamiento = tipo_asentamiento;
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
				
}
