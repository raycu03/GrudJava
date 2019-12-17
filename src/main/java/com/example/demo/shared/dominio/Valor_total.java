package com.example.demo.shared.dominio;

import com.example.demo.exeptions.NegativoExeception;

public class Valor_total {
	private final Float valor_total;
	
	 public Valor_total(Float valor_total) {
		 this.valor_total=valor_total;
			if (valor_total<1) {
				throw new NegativoExeception();
				
			}
	}

	public Float getValor_total() {
		return valor_total;
	}
	 
	 

}
