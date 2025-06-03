package com.ilramlima.projetoSpring.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ilramlima.projetoSpring.services.exceptions.DatabaseException;
import com.ilramlima.projetoSpring.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandarError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		
		String error = "Dados não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}

	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandarError> Database(DatabaseException e, HttpServletRequest request){
		
		String error = "Error ao excluir";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
