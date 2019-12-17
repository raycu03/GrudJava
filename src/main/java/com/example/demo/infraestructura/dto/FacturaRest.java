package com.example.demo.infraestructura.dto;

import java.util.List;

public class FacturaRest {
	
	private Long id;
	private Float valor_total;
	private String Nombre_cliente;
	private List<ItemRest> items;
	
	public FacturaRest() {
		// TODO Auto-generated constructor stub
	}
	
	public FacturaRest(Long id, Float valor_total, String nombre_cliente, List<ItemRest> items) {
		super();
		this.id = id;
		this.valor_total = valor_total;
		Nombre_cliente = nombre_cliente;
		this.items = items;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getValor_total() {
		return valor_total;
	}
	public void setValor_total(Float valor_total) {
		this.valor_total = valor_total;
	}
	public String getNombre_cliente() {
		return Nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		Nombre_cliente = nombre_cliente;
	}
	public List<ItemRest> getItems() {
		return items;
	}
	public void setItems(List<ItemRest> items) {
		this.items = items;
	}
	
	
	
	

}
