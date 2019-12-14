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
	public Producto dto(ProductoDto o) { 
		return Producto.of( new Id(o.getId()),new Codigo(o.getCodigo()), new Nombre(o.getNombre()), new Valor(o.getValor()));
	
	}

	@Override
	public ProductoDto model(Producto i) {
		// TODO Auto-generated method stub
		return new ProductoDto(i.getId().getId(), i.getCodigo().getCodigo(), i.getNombre().getNombre(), i.getValor().getvalor());
	}

}
