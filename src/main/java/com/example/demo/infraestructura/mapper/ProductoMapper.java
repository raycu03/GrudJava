package com.example.demo.infraestructura.mapper;

import com.example.demo.dominio.model.Producto;
import com.example.demo.dto.ProductoDto;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;
import com.example.demo.shared.infraestructura.mapper.MapperApiRest;

public class ProductoMapper implements MapperApiRest<Producto, ProductoDto>{
	
	@Override
	public Producto recibir(ProductoDto o) { 
		return Producto.of(new Nombre(o.getNombre()), new Valor(o.getValor()), new Codigo(o.getCodigo()), new Id(o.getId()));
	
	}

	@Override
	public ProductoDto convertir(Producto i) {
		// TODO Auto-generated method stub
		return null;
	}

}
