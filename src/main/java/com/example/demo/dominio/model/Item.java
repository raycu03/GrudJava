package com.example.demo.dominio.model;

import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Valor_total;

public class Item {
	
	private final Id id;
	private final Cantidad cantidad;
	private final Valor_total valor_total;
	private final Producto producto;
	
	public Item(Id id, Cantidad cantidad, Valor_total valor_total, Producto producto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.valor_total = valor_total;
		this.producto = producto;
	}

	public Id getId() {
		return id;
	}

	public Cantidad getCantidad() {
		return cantidad;
	}

	public Valor_total getValor_total() {
		return valor_total;
	}

	public Producto getProducto() {
		return producto;
	}

	public static Item of(Id id, Cantidad cantidad, Valor_total valor_total, Producto producto) {
		// TODO Auto-generated method stub
		return new Item(id, cantidad, valor_total, producto);
	}
	
	
	

	

}
