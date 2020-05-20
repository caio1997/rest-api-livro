package com.enterprise.livro.controller.exceptions;

import java.io.Serializable;

public class StandardError2 implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String path;

	
	public StandardError2() {
	}

	public StandardError2(String message, String path) {
		super();
		this.message = message;
		this.path = path;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
