package com.example.demo.infraestructura.repository.adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.model.Producto;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.exeptions.RegistroNoEncontradoExeception;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.infraestructura.repository.database.ProductoRepository;
import com.example.demo.shared.dominio.Id;

@Service
public class ProductoAdapter implements ProductoService {

	@Autowired
	public ProductoRepository productoRepository;

	@Autowired
	public ProductoMapper productoMapper;

	@Override
	public List<Producto> buscarPorIds(List<Id> id) {
		return productoRepository.findAllById(id.stream().map(codigo -> codigo.getId()).collect(Collectors.toList()))
				.stream().map(producto -> productoMapper.recibir(producto)).collect(Collectors.toList());
	}

	@Override
	public List<Producto> buscarTodo() {
		return productoMapper.recibir(productoRepository.findAll());
	}

	@Override
	public void guardar(Producto producto) {
		productoRepository.save(productoMapper.convertir(producto));
	}

	@Override
	public Producto buscarXId(Long id) {
		// TODO Auto-generated method stub

		Producto producto = productoMapper
				.recibir(productoRepository.findById(id).orElseThrow(() -> new RegistroNoEncontradoExeception()));

		return producto;
	}

	public void borrar(Long id) {
		productoRepository.deleteById(id);

	}

}
