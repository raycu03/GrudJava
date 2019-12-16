package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aplicacion.ProductoAplicacion;
import com.example.demo.dominio.model.Producto;
import com.example.demo.infraestructura.mapper.ProductoMapper;

@RequestMapping
@RestController("/producto")
public class ProductoControllers {
	
	@Autowired
	ProductoAplicacion productoAplicacion;
	
	@Autowired
	ProductoMapper productoMapper;
	
	
	@PostMapping
	public void agregar(@RequestBody Producto producto) {
		
		//productoAplicacion.crear(producto)
	}

}
