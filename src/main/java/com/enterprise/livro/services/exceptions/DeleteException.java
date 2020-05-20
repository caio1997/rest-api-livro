package com.enterprise.livro.services.exceptions;

public class DeleteException  extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public DeleteException(String msg) {
		super(msg);
	}
}
