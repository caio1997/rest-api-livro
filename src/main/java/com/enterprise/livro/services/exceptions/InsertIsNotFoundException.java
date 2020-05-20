package com.enterprise.livro.services.exceptions;

public class InsertIsNotFoundException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InsertIsNotFoundException(String msg) {
		super(msg);
	}
}
