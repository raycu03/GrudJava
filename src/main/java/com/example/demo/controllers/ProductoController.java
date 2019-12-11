package com.example.demo.controllers;

import java.util.*;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.*;


import com.example.demo.dto.Producto;
import com.example.demo.exeptions.RegistroNoEncontradoExeception;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	private List <Producto> repositori =new ArrayList<>();

	@PostMapping void crear (@RequestBody Producto Producto) {
		repositori.add(Producto);
	}
	
	@GetMapping("/{codigo}") Producto buscar(@PathVariable String codigo) {
		return repositori.stream().filter(Producto  -> Producto.getCodigo().matches(codigo))
				.findAny().orElseThrow(()-> new RegistroNoEncontradoExeception());
	}
	
	@DeleteMapping("/{codigo}") void borrar(@PathVariable String codigo) {
		Producto eli= repositori.stream().filter(Producto  -> Producto.getCodigo().matches(codigo))
		.findAny().orElseThrow(()-> new RegistroNoEncontradoExeception());
		repositori.remove(eli);
	}
	
	//actualizar producto
		@PutMapping ("/editar")
		public void actualizar( @RequestBody Producto producto) {
			
			Producto actualizar=  repositori.stream().filter(Producto -> Producto.getCodigo().matches(producto.getCodigo()))
					.findAny().orElseThrow(() -> new RuntimeException("objeto actualizado"));
			
			//el no editado
			int repositorioIndexOf= repositori.indexOf(actualizar);
			repositori.set(repositorioIndexOf,producto);
			
		}


}
