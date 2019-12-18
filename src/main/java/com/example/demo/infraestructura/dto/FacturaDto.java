package com.example.demo.infraestructura.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="factura")
public class FacturaDto extends BaseEntity{
	

	private Float valor_total;
	private String Nombre_cliente;
	
	@OneToMany(targetEntity =ItemDto.class ,cascade = CascadeType.ALL)
	private List<ItemDto> list;

	public FacturaDto() {
		// TODO Auto-generated constructor stub
	}
	
	public FacturaDto(Float valor_total, String nombre_cliente, List<ItemDto> list) {
		super();
		this.valor_total = valor_total;
		Nombre_cliente = nombre_cliente;
		this.list = list;
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

	public List<ItemDto> getList() {
		return list;
	}

	public void setList(List<ItemDto> list) {
		this.list = list;
	}
	


	

}
