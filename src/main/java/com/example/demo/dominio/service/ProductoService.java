package com.example.demo.dominio.service;

import java.util.List;

import com.example.demo.dominio.model.Producto;
import com.example.demo.shared.dominio.Id;

public interface ProductoService {

	public List<Producto> buscarPorIds(List<Id> id);
	public void guardar (Producto producto);
	public Producto buscarXId(Long id);
	public List<Producto> buscarTodo();
	public void borrar (Long id);
	public void actualizar(Producto producto);

	

}