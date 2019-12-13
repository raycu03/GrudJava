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
	
	@GetMapping("/{codigo}") Producto buscar(@PathVariable String codigo) {

		return productoRepository.findById(codigo).orElseThrow(() -> new RegistroNoEncontradoExeception());
	}
	
	@DeleteMapping("/{codigo}") void borrar(@PathVariable String codigo) {
		productoRepository.findById(codigo).orElseThrow(() -> new RegistroNoEncontradoExeception());
		productoRepository.deleteById(codigo);
		
		
	}
	
		@PutMapping ()
		public void actualizar( @RequestBody Producto producto) {
			
			productoRepository.findById(producto.getCodigo()).orElseThrow(() -> new RegistroNoEncontradoExeception());
			productoRepository.save(producto);

		}
		
		
		
		


}
