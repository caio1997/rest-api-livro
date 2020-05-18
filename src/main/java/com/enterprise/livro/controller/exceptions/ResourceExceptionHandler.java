package com.enterprise.livro.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.enterprise.livro.services.exceptions.ExceptionIdIsNotFound;
import com.enterprise.livro.services.exceptions.ExceptionsGerais;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ExceptionsGerais.class)
	public ResponseEntity<StandardError> resourceNotFound(ExceptionsGerais e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ExceptionIdIsNotFound.class)
	public ResponseEntity<StandardError2> resourceNotFound(ExceptionIdIsNotFound e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError2 err = new StandardError2(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
}
