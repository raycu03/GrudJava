package com.example.demo.controllers;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dominio.service.ProductoService;
import com.example.demo.dto.ProductoDto;
import com.example.demo.infraestructura.mapper.ProductoMapper;


@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ProductoMapper productoMapper;
	
	
	@GetMapping()
	List<ProductoDto> consultar(){
		return productoService.buscarTodo().stream().map(producto -> productoMapper.convertir(producto)).collect(Collectors.toList());
		
	}
	

	@PostMapping void crear (@RequestBody ProductoDto producto) {
		Random rnd =new Random();
		producto.setId(Math.abs(rnd.nextLong())%100);
		System.out.print("valor: "+producto.getId());
		productoService.guardar(productoMapper.recibir(producto));
		
	}
	
	@GetMapping("/{id}") ProductoDto buscar(@PathVariable Long id) {
		
		
		return productoMapper.convertir(productoService.buscarXId(id));
			
	}

//	@DeleteMapping("/{codigo}") void borrar(@PathVariable Long id) {
//		productoRepository.findById(id).orElseThrow(() -> new RegistroNoEncontradoExeception());
//		productoRepository.deleteById(id);
//		
//		
//	}
//	
//		@PutMapping ()
//		public void actualizar( @RequestBody ProductoDto producto) {
//			
//			productoRepository.findById(producto.getId()).orElseThrow(() -> new RegistroNoEncontradoExeception());
//			productoRepository.save(producto);
//
//		}
//		
		
		
		


}
