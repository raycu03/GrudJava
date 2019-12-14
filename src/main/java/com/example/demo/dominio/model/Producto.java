package com.example.demo.dominio.model;

import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;

public class Producto {

    private final Id id;//numero
	private final Codigo codigo;
	private final Nombre nombre;
	private final Valor valor;
	
 
	private Producto(Id id, Codigo codigo, Nombre nombre, Valor valor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}
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
	public static Producto of(Id id, Codigo codigo, Nombre nombre, Valor valor) {
		// TODO Auto-generated method stub
		return new Producto(id, codigo, nombre, valor);
	}




	
	
}
