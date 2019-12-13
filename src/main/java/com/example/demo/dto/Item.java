package com.example.demo.dto;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item extends BaseEntity{

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private float cantidad;
	private float valor_total;
	
	@OneToOne(targetEntity = Producto.class)
    private Producto producto;
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Item(long id, float cantidad, float valor_total, Producto producto) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.valor_total = valor_total;
		this.producto = producto;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public float getCantidad() {
		return cantidad;
	}


	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}


	public float getValor_total() {
		return valor_total;
	}


	public void setValor_total(float valor_total) {
		this.valor_total = valor_total;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}



}
