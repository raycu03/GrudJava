package com.example.demo.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.dto.Producto;
import com.example.demo.exeptions.RegistroNoEncontradoExeception;
import com.example.demo.repository.ProductoRepository;


@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoRepository  productoRepository;
	
	
	@GetMapping()
	List<Producto> consultar(){
		return productoRepository.findAll();
		
	}
	

	@PostMapping void crear (@RequestBody Producto producto) {
		productoRepository.save(producto);

		
	}
	
	@GetMapping("/{id}") Producto buscar(@PathVariable Long id) {

		return productoRepository.findById(id).orElseThrow(() -> new RegistroNoEncontradoExeception());
	}
	
	@DeleteMapping("/{codigo}") void borrar(@PathVariable Long id) {
		productoRepository.findById(id).orElseThrow(() -> new RegistroNoEncontradoExeception());
		productoRepository.deleteById(id);
		
		
	}
	
		@PutMapping ()
		public void actualizar( @RequestBody Producto producto) {
			
			productoRepository.findById(producto.getId()).orElseThrow(() -> new RegistroNoEncontradoExeception());
			productoRepository.save(producto);

		}
		
		
		
		


}
