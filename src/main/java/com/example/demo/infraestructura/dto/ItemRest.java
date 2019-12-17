package com.example.demo.infraestructura.dto;


public class ItemRest {
	
    private Long id;
	private Float cantidad;
	private Float valor_total;
	private ProductoRest productoRest;
	
	public ItemRest() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ItemRest(Long id, Float cantidad, Float valor_total, ProductoRest productoRest) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.valor_total = valor_total;
		this.productoRest = productoRest;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getCantidad() {
		return cantidad;
	}
	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	public Float getValor_total() {
		return valor_total;
	}
	public void setValor_total(Float valor_total) {
		this.valor_total = valor_total;
	}
	public ProductoRest getProductoRest() {
		return productoRest;
	}
	public void setProductoRest(ProductoRest productoRest) {
		this.productoRest = productoRest;
	}
	
	


}
