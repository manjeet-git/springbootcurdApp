package com.springboot.curd.custom.exception;

public class TeamResponseException {
	String message;
	Boolean success;
	
	public TeamResponseException(String message, Boolean success) {
		this.message = message;
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public Boolean getSuccess() {
		return success;
	}

	

}
