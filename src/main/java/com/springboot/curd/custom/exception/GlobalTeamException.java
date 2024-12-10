package com.springboot.curd.custom.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalTeamException {
	
	@ExceptionHandler(TeamNotFoundException.class)
	public ResponseEntity<TeamResponseException> teamNotFoundException(TeamNotFoundException teMsg){
		TeamResponseException trException=new TeamResponseException(teMsg.getMessage(), false);
		
		return new ResponseEntity<TeamResponseException>(trException, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handlerMethodArgumentNotValidException(MethodArgumentNotValidException manve){
		Map<String, String> errorMap=new HashMap<>();
		manve.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		
		return errorMap;
	}

}
