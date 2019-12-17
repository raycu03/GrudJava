package com.example.demo.infraestructura.dto;

public class ProductoRest {

	private Long id;
	private String codigo;
	private String nombre;
	private Float valor;
	
	public ProductoRest() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ProductoRest(Long id, String codigo, String nombre, Float valor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.valor = valor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
