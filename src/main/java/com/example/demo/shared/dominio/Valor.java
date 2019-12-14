package com.example.demo.shared.dominio;

import com.example.demo.exeptions.NegativoExeception;
import com.example.demo.exeptions.RangoExeception;

public class Valor {
	
	private final Float valor;
	
	public Valor( Float valor) {
		this.valor = valor;
		
		if (valor<1) {
			throw new NegativoExeception();
			
		}
		if (valor>9999.0) {
			
			throw new RangoExeception();
		}
		
	}

	public Float getvalor() {
		return valor;
	}
	

}
