package com.example.demo.infraestructura.mapper;

import com.example.demo.dominio.model.Item;
import com.example.demo.dominio.model.Producto;
import com.example.demo.infraestructura.dto.ItemDto;
import com.example.demo.infraestructura.dto.ItemRest;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.shared.dominio.Cantidad;
import com.example.demo.shared.dominio.Codigo;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre;
import com.example.demo.shared.dominio.Valor;
import com.example.demo.shared.dominio.Valor_total;
import com.example.demo.shared.infraestructura.mapper.MapperApiRest;
import com.example.demo.shared.infraestructura.mapper.MapperRepocitory;

public class ItemMapper implements MapperRepocitory<Item, ItemDto>, MapperApiRest<Item, ItemRest>{


	@Override
	public Item dtoDominio(ItemDto o) {
		return Item.of(new Id(o.getId()), new Cantidad(o.getCantidad()), new Valor_total(o.getValor_total()),
				Producto.of(new Id(o.getProducto().getId()), new Codigo(o.getProducto().getCodigo()),
						new Nombre(o.getProducto().getNombre()), new Valor(o.getProducto().getValor())));
		 
	}

	@Override
	public ItemDto dominiodto(Item i) {
		ItemDto it= new ItemDto();
		ProductoDto producto = new ProductoDto();
		it.setId(i.getId().getId());
		it.setCantidad(i.getCantidad().getCantidad());
		it.setValor_total(i.getValor_total().getValor_total());

		producto.setId(i.getProducto().getId().getId());
		producto.setCodigo(i.getProducto().getCodigo().getCodigo());
		producto.setNombre(i.getProducto().getNombre().getNombre());
		producto.setValor(i.getProducto().getValor().getvalor());
		
		return it;
	}
	@Override
	public Item dtoDominioapi(ItemRest o) {
		
		return Item.of(new Id(o.getId()), new Cantidad(o.getCantidad()), new Valor_total(o.getValor_total()),
				Producto.of(new Id(o.getProductoRest().getId()), new Codigo(o.getProductoRest().getCodigo())
						, new Nombre(o.getProductoRest().getNombre()), new Valor(o.getProductoRest().getValor())));
	}

	@Override
	public ItemRest dominiodtoapi(Item i) {
		ItemRest it= new ItemRest();
		ProductoRest producto= new ProductoRest();
		it.setId(i.getId().getId());
		it.setCantidad(i.getCantidad().getCantidad());
		it.setValor_total(i.getValor_total().getValor_total());
		
		producto.setId(i.getProducto().getId().getId());
		producto.setCodigo(i.getProducto().getCodigo().getCodigo());
		producto.setNombre(i.getProducto().getNombre().getNombre());
		producto.setValor(i.getProducto().getValor().getvalor());
		
		return it;
	}



}
