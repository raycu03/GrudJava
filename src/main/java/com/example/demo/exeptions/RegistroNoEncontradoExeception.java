package com.example.demo.exeptions;

public class RegistroNoEncontradoExeception extends RuntimeException{

	public RegistroNoEncontradoExeception() {
		
		super("registro no encontrado");
		
	}
}
