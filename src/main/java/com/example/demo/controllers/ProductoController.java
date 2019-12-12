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
	
	private List <Producto> repositori =new ArrayList<>();
	
	@GetMapping()
	List<Producto> consultar(){
		return productoRepository.findAll();
		
	}
	

	@PostMapping void crear (@RequestBody Producto Producto) {
		productoRepository.save(Producto);
		//repositori.add(Producto);
		
	}
	
	@GetMapping("/{codigo}") Optional<Producto> buscar(@PathVariable String codigo) {
		/*return repositori.stream().filter(Producto  -> Producto.getCodigo().matches(codigo))
				.findAny().orElseThrow(()-> new RegistroNoEncontradoExeception());*/
		//return productoRepository.findById(codigo);
		return productoRepository.findById(codigo);
	}
	
	@DeleteMapping("/{codigo}") void borrar(@PathVariable String codigo) {
		//repositori.remove(eli);
		productoRepository.deleteById(codigo);
		
		
	}
	
	//actualizar producto
		@PutMapping ("/editar")
		public void actualizar( @RequestBody Producto producto) {
			
			/*Producto actualizar=  repositori.stream().filter(Producto -> Producto.getCodigo().matches(producto.getCodigo()))
					.findAny().orElseThrow(() -> new RegistroNoEncontradoExeception());
			
		
			int repositorioIndexOf= repositori.indexOf(actualizar);
			repositori.set(repositorioIndexOf,producto);*/

		}
		
		


}
