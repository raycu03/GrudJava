package com.example.demo.exeptions;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.ErrorCode;



@RestControllerAdvice 

public class ExceptionsHandler {

	private static final Logger LOG= Logger.getLogger(ExceptionsHandler.class.getName());
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorCode handleExeption(Exception e) {
		ErrorCode ec= new ErrorCode();
		ec.setCodigo(this.getId());
		ec.setMensaje("error no encontrado");
		logError(ec, e);

		
		return ec;
	}
	
	@ExceptionHandler(RegistroNoEncontradoExeception.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode registroNoEncontrado(RegistroNoEncontradoExeception e) {
		ErrorCode ec= new ErrorCode();
		ec.setCodigo(this.getId());
		ec.setMensaje(e.getMessage());
		logError(ec, e);
		
		return ec;
		
	}
	
	private void logError(ErrorCode ec,Exception e) {
		LOG.severe(ec.getCodigo());
		LOG.severe(ec.getMensaje());
		LOG.severe(ec.getCodigo());
		LOG.severe(e.getMessage());
		
		
	}
	
	public String getId() {
		
		final String uuid = UUID.randomUUID().toString().replace("-", "");
		
		return uuid;
	}
	
}
