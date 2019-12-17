package com.example.demo.infraestructura.dto;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.dto.BaseEntity;

@Entity
@Table(name="items")
public class ItemDto extends BaseEntity{

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private Float cantidad;
	private Float valor_total;
	
	@OneToOne(targetEntity = ProductoDto.class)
    private ProductoDto producto;
	
	public ItemDto() {
		// TODO Auto-generated constructor stub
	}
	

	public ItemDto(Long id, Float cantidad, Float valor_total, ProductoDto producto) {
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

	public ProductoDto getProducto() {
		return producto;
	}

	public void setProducto(ProductoDto producto) {
		this.producto = producto;
	}
	



}
