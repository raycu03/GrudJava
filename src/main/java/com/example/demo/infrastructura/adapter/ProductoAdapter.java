package com.example.demo.infrastructura.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dominio.model.Producto;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.infraestructura.repository.database.ProductoRepository;
import com.example.demo.shared.dominio.Id;

public class ProductoAdapter implements ProductoService{
	@Autowired
	public ProductoRepository productoRepository;
	
	@Autowired
	public ProductoMapper productoMapper;

	@Override
	public List<Producto> buscarPorIds(List<Id> id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Producto> buscarTodo(){
		return productoMapper.recibir(productoRepository.findAll());
	}

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(productoMapper.convertir(producto));
	}

	@Override
	public Producto buscarXId(Id id) {
		// TODO Auto-generated method stub
		return productoMapper.recibir(productoRepository.findById(id.getValue()).get());
	}
	
}
