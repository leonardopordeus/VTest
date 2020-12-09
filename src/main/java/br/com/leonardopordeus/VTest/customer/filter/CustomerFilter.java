package br.com.leonardopordeus.VTest.customer.filter;

import java.io.Serializable;

public class CustomerFilter implements Serializable {

	private static final long serialVersionUID = 3235509634070135675L;
	private String documentId;
	private String name;
	private String zipCode;
	
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
