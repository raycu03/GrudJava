package com.example.demo.dominio.model;

import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;

public class Producto {

    private Id id;//numero
	private Codigo codigo;
	private Nombre nombre;
	private Valor valor;
	
	public Id getId() {
		return id;
	}
	public Codigo getCodigo() {
		return codigo;
	}
	public Nombre getNombre() {
		return nombre;
	}
	public Valor getValor() {
		return valor;
	}
	public static Producto of(Nombre nombre2, Valor valor2, Codigo codigo2, Id id2) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
