package com.example.demo.dto;


import javax.persistence.Entity;

import javax.persistence.Table;

@Entity
@Table(name="productos")
public class ProductoDto extends BaseEntity{
	

	private String codigo;
	private String nombre;
	private Float valor;
	
	
	
	public ProductoDto(String codigo, String nombre, Float valor) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}

	public ProductoDto() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	


}
