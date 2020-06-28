package com.teamdev.opticacheguigo.opticacheguigo.dto.request.cp;
public class CPErrorDto {
	
	 private Boolean error;
	 private Float code_error;
	 private String error_message;
	 private String response;
	 
	 
	public CPErrorDto(Boolean error, Float code_error, String error_message, String response) {
		this.error = error;
		this.code_error = code_error;
		this.error_message = error_message;
		this.response = response;
	}
	
	public CPErrorDto() {
		
	}
	
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	public Float getCode_error() {
		return code_error;
	}
	public void setCode_error(Float code_error) {
		this.code_error = code_error;
	}
	public String getError_message() {
		return error_message;
	}
	public void setError_message(String error_message) {
		this.error_message = error_message;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

	 
		
						
			
}
