package com.example.demo.dominio.service;

import java.util.List;

import com.example.demo.dominio.model.Producto;
import com.example.demo.shared.dominio.Id;

public interface ProductoService {

	public List<Id> buscarPorIds(List<Id> ids);
	
	public Producto guardar(Producto producto);
	
	public Producto buscarId(Id id);
	

}