package com.example.demo.shared.dominio;

import com.example.demo.exeptions.NombreExeception;

public class Nombre {
	
	public Nombre(String nombre) {
		
		if(nombre.matches("[a-z]*")!=true) {
			
			throw new NombreExeception();
		}
			
	}

}
