package com.example.demo.shared.dominio;

import com.example.demo.exeptions.NombreExeception;

public class Nombre {
	
	private final String value;
	
	public Nombre(String nombre) {
		
		this.value= nombre;
		if(nombre.matches("[a-z]*")!=true) {
			
			throw new NombreExeception();
		}
			
	}

	public String getValu() {
		return value;
	}
	

}
