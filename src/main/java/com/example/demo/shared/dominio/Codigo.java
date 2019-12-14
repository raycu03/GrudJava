package com.example.demo.shared.dominio;

import com.example.demo.exeptions.CaracteresExeception;

public class Codigo {

	private final String value;

	public Codigo(String codigo) {
	
		this.value = codigo;
		if (codigo.length()>=64 || codigo.length() <=32) {
			
			throw new CaracteresExeception();
		}
	}

	public String getValue() {
		return value;
	}



	
}
