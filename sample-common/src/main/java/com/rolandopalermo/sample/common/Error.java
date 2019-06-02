package com.rolandopalermo.sample.common;

public class Error {

	private String errorMessage;
	private String statusCode;

	public Error() {
	}
	
	public Error(String errorMessage, String statusCode) {
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
}