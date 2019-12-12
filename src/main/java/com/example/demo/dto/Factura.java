package com.example.demo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="factura")
public class Factura {
	
	@Id
	private Long id;
	private float valor_total;
	private String Nombre_cliente;
	
	@OneToMany()
	private List<Item> list;

	public Factura() {
		// TODO Auto-generated constructor stub
	}
	
	public Factura(Long id, float valor_total, String nombre_cliente, List<Item> list) {
		super();
		this.id = id;
		this.valor_total = valor_total;
		Nombre_cliente = nombre_cliente;
		this.list = list;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getValor_total() {
		return valor_total;
	}

	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}

	public String getNombre_cliente() {
		return Nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		Nombre_cliente = nombre_cliente;
	}

	public List<Item> getList() {
		return list;
	}

	public void setList(List<Item> list) {
		this.list = list;
	}
	
	

}
