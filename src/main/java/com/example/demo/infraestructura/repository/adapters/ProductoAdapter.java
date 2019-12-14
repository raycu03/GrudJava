package com.example.demo.infraestructura.repository.adapters;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dominio.model.Producto;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.shared.dominio.Id;

@Service
public class ProductoAdapter implements ProductoService{

	@Override
	public List<Id> buscarPorIds(List<Id> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto guardar(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto buscarId(Id id) {
		// TODO Auto-generated method stub
		return null;
	}

}
