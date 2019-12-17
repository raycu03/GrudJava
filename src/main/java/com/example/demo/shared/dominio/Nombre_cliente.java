package com.example.demo.shared.dominio;

import com.example.demo.exeptions.NombreExeception;

public class Nombre_cliente {

	private final String nombre_cliente;
	
	public Nombre_cliente(String nombre_cliente) {
		
		this.nombre_cliente= nombre_cliente;
		if(!nombre_cliente.matches("[A-Z].*")) {
			
			throw new NombreExeception();
		}
			
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}
	

	
}
