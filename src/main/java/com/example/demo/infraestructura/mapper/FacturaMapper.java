package com.example.demo.infraestructura.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dominio.model.Factura;
import com.example.demo.dominio.model.Item;
import com.example.demo.infraestructura.dto.FacturaDto;
import com.example.demo.infraestructura.dto.FacturaRest;
import com.example.demo.shared.dominio.Id;
import com.example.demo.shared.dominio.Nombre_cliente;
import com.example.demo.shared.dominio.Valor_total;
import com.example.demo.shared.infraestructura.mapper.MapperApiRest;
import com.example.demo.shared.infraestructura.mapper.MapperRepocitory;

@Component
public class FacturaMapper implements MapperApiRest<Factura, FacturaDto>, MapperRepocitory<Factura, FacturaRest>{

	@Autowired
	ItemMapper itemMapper;
	
	@Override
	public Factura dtoDominioapi(FacturaDto o) {
		return Factura.of(new Id(o.getId()), new Valor_total(o.getValor_total()), new Nombre_cliente(o.getNombre_cliente()),
				o.getList().stream()
				.map(item-> itemMapper.dtoDominio(item)).collect(Collectors.toList()));
		 
	}

	@Override
	public FacturaDto dominiodtoapi(Factura i) {
		FacturaDto factura = new FacturaDto();
		factura.setId(i.getId().getId());
		factura.setValor_total(i.getValor_total().getValor_total());
		factura.setNombre_cliente(i.getNombre_cliente().getNombre_cliente());
		
		factura.setList(i.getItems().stream().map(item -> itemMapper.dominiodto(item)).collect(Collectors.toList()));
		
		return factura;
	}
	
	@Override
	public Factura dtoDominio(FacturaRest o) {
		Factura.of(new Id(o.getId()), new Valor_total(o.getValor_total()), new Nombre_cliente(o.getNombre_cliente()),
				o.getItems().stream()
				.map(item-> itemMapper.dtoDominioapi(item)).collect(Collectors.toList()));
		return null;
	}

	@Override
	public FacturaRest dominiodto(Factura i) {
		FacturaRest factura = new FacturaRest();
		factura.setId(i.getId().getId());
		factura.setValor_total(i.getValor_total().getValor_total());
		factura.setNombre_cliente(i.getNombre_cliente().getNombre_cliente());
		
		factura.setItems(itemMapper.dominiodtoapi(i.getItems()));
		
		return factura;
	}

}
