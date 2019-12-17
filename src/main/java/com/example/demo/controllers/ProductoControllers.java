package com.example.demo.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aplicacion.ProductoAplicacion;

import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.ProductoMapper;


@RestController
@RequestMapping("/producto")
public class ProductoControllers {
	
	@Autowired
	ProductoAplicacion productoAplicacion;
	
	@Autowired
	ProductoMapper productoMapper;
	
	//dto=rest
	//producto 
	
	@PostMapping
	public String agregar(@RequestBody ProductoRest producto) {
		Random rnd =new Random();
		if(producto.getId()==null){
			producto.setId(Math.abs(rnd.nextLong())%100);
		}
		return productoAplicacion.crear(producto);
		
		
	}
	
	@GetMapping("/{id}")
	public ProductoRest buscar(@PathVariable Long id) {
		return productoAplicacion.buscar(id);
		
	}
	
	@GetMapping()
	public List<ProductoRest> buscartodo(){
		
		return productoAplicacion.consultar();
		
	}
	
	@DeleteMapping("/{id}")
	public String borrar(@PathVariable Long id) {
		
		return productoAplicacion.borrar(id);
		
	}
	
	@PutMapping
	public void actualizar(@RequestBody ProductoRest producto) {
		
		productoAplicacion.actualizar(producto);
		
	}
	
	
	
		

}
