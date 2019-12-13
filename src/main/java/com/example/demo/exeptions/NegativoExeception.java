package com.example.demo.exeptions;

public class NegativoExeception extends RuntimeException{
	
	public NegativoExeception() {
		super("el valor no puede ser negativo ");
	}

}
