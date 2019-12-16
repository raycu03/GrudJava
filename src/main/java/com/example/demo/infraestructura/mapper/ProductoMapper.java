package com.example.demo.infraestructura.mapper;

import org.springframework.stereotype.Component;

import com.example.demo.dominio.model.Producto;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;
import com.example.demo.shared.infraestructura.mapper.MapperApiRest;
import com.example.demo.shared.infraestructura.mapper.MapperRepocitory;

@Component
public class ProductoMapper implements MapperApiRest<Producto, ProductoDto>, MapperRepocitory<Producto, ProductoRest> {

	public Producto apirecibir(ProductoDto o) {
		return Producto.of(new Id(o.getId()), new Codigo(o.getCodigo()), new Nombre(o.getNombre()),
				new Valor(o.getValor()));

	}

	public ProductoDto apiconvertir(Producto i) {
		ProductoDto pd = new ProductoDto();
		pd.setId(i.getId().getId());
		pd.setCodigo(i.getCodigo().getCodigo());
		pd.setNombre(i.getNombre().getNombre());
		pd.setValor(i.getValor().getvalor());
		return pd;
	}

	@Override
	public Producto recibir(ProductoRest o) {
		// TODO Auto-generated method stub

		return Producto.of(new Id(o.getId()), new Codigo(o.getCodigo()), new Nombre(o.getNombre()),
				new Valor(o.getValor()));
	}

	@Override
	public ProductoRest convertir(Producto i) {
		ProductoRest pd = new ProductoRest();
		pd.setId(i.getId().getId());
		pd.setCodigo(i.getCodigo().getCodigo());
		pd.setNombre(i.getNombre().getNombre());
		pd.setValor(i.getValor().getvalor());
		return pd;
	}

}
