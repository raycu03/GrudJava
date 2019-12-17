package com.example.demo.dominio.model;

import java.util.List;

import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre_cliente;
import com.example.demo.shared.dominio.Valor_total;

public class Factura {
	
    private final Id id;//numero
	private final Valor_total valor_total;
	private final Nombre_cliente nombre_cliente;
	private final List<Item> items;
	
	
	

	public Factura(Id id, Valor_total valor_total, Nombre_cliente nombre_cliente, List<Item> items) {
		super();
		this.id = id;
		this.valor_total = valor_total;
		this.nombre_cliente = nombre_cliente;
		this.items = items;
	}
	
	public static Factura of(Id id, Valor_total valor_total, Nombre_cliente nombre_cliente, List<Item> items) {
		// TODO Auto-generated method stub
		return new Factura( id, valor_total, nombre_cliente, items);
	}
	public Id getId() {
		return id;
	}
	public Valor_total getValor_total() {
		return valor_total;
	}
	public Nombre_cliente getNombre_cliente() {
		return nombre_cliente;
	}
	public List<Item> getItems() {
		return items;
	}
	
	
	
	

}
