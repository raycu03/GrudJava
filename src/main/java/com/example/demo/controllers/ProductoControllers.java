package com.example.demo.controllers;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dominio.service.ProductoService;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.mapper.ProductoMapper;

@RestController
@RequestMapping("/producto")
public class ProductoControllers {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ProductoMapper productoMapper;
	
	
	@GetMapping()
	List<ProductoDto> consultar(){
		return productoService.buscarTodo().stream().map(producto -> productoMapper.dominiodtoapi(producto)).collect(Collectors.toList());
		
	}
	

	@PostMapping void crear (@RequestBody ProductoDto producto) {
		Random rnd =new Random();
		producto.setId(Math.abs(rnd.nextLong())%100);
		System.out.print("valor: "+producto.getId());
		productoService.guardar(productoMapper.dtoDominioapi(producto));
		
	}
	
	@GetMapping("/{id}") ProductoDto buscar(@PathVariable Long id) {
		
		
		return productoMapper.dominiodtoapi(productoService.buscarXId(id));
			
	}

	@DeleteMapping("/{codigo}") String borrar(@PathVariable Long id) {
		productoService.borrar(id);
		return ("dato borrado");		
		
	}
	
		@PutMapping ()
		public void actualizar( @RequestBody ProductoDto producto) {
			
			productoMapper.dominiodtoapi(productoService.buscarXId(producto.getId()));
			productoService.actualizar(productoMapper.dtoDominioapi(producto));

		}
		
	

}