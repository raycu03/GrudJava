package com.example.demo.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.dto.ProductoDto;
import com.example.demo.exeptions.RegistroNoEncontradoExeception;
import com.example.demo.infraestructura.repository.database.ProductoRepository;


@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoRepository  productoRepository;
	
	
	@GetMapping()
	List<ProductoDto> consultar(){
		return productoRepository.findAll();
		
	}
	

	@PostMapping void crear (@RequestBody ProductoDto producto) {
		productoRepository.save(producto);

		
	}
	
	@GetMapping("/{id}") ProductoDto buscar(@PathVariable Long id) {

		return productoRepository.findById(id).orElseThrow(() -> new RegistroNoEncontradoExeception());
	}
	
	@DeleteMapping("/{codigo}") void borrar(@PathVariable Long id) {
		productoRepository.findById(id).orElseThrow(() -> new RegistroNoEncontradoExeception());
		productoRepository.deleteById(id);
		
		
	}
	
		@PutMapping ()
		public void actualizar( @RequestBody ProductoDto producto) {
			
			productoRepository.findById(producto.getId()).orElseThrow(() -> new RegistroNoEncontradoExeception());
			productoRepository.save(producto);

		}
		
		
		
		


}
