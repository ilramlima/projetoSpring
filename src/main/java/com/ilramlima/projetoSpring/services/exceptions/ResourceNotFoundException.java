package com.ilramlima.projetoSpring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		
		super("Dados não encontrado. ID: " + id);
	}

}
