package br.com.leonardopordeus.VTest.customer.dto;

import java.io.Serializable;

public class ExceptionDto implements Serializable {
	
	final long serialVersionUID = 4118741562439742337L;
	
	private String type;
	private String message;
	
	public ExceptionDto(String type, String message) {
		super();
		this.type = type;
		this.message = message;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
