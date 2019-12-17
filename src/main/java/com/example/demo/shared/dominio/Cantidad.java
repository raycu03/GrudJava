package com.example.demo.shared.dominio;

import com.example.demo.exeptions.NegativoExeception;

public class Cantidad {

	private final Float cantidad;
	public Cantidad(Float cantidad) {
		this.cantidad= cantidad;
		if (cantidad<1) {
			throw new NegativoExeception();
			
		}
		
	}
	public Float getCantidad() {
		return cantidad;
	}
	
	
}
