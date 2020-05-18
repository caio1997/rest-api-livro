package com.enterprise.livro.services.exceptions;

public class ExceptionIdIsNotFound extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ExceptionIdIsNotFound(String msg) {
		super(msg);
	}

}
