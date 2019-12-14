package com.example.demo.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class ProductoDto extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;//numero
	private String codigo;
	private String nombre;
	private Float valor;
	
	public ProductoDto() {
		// TODO Auto-generated constructor stub
	}
	public ProductoDto(Long id, String codigo, String nombre, Float valor) {
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
