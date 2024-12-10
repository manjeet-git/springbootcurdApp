package com.springboot.curd.custom.exception;


public class TeamNotFoundException extends RuntimeException{
	
	public TeamNotFoundException(String msg) {
		super(msg);
	}

}
