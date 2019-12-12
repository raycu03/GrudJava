package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Item;
import com.example.demo.dto.Producto;
import com.example.demo.exeptions.RegistroNoEncontradoExeception;
import com.example.demo.repository.ItemRepository;


@RestController
@RequestMapping("/item")
public class ItemControllers {

	@Autowired
	private ItemRepository  itemRepository;
	
	@GetMapping()
	List<Item> consultar(){
		return itemRepository.findAll();
		
	}
	
	@PostMapping void crear (@RequestBody Producto Producto) {
		itemRepository.save(Producto);
		//repositori.add(Producto);
		
	}
	
	@GetMapping("/{codigo}") Producto buscar(@PathVariable String codigo) {
		/*return repositori.stream().filter(Producto  -> Producto.getCodigo().matches(codigo))
				.findAny().orElseThrow(()-> new RegistroNoEncontradoExeception());*/
		//return productoRepository.findById(codigo);
		return itemRepository.findById(codigo).orElseThrow(() -> new RegistroNoEncontradoExeception());
	}
	
	@DeleteMapping("/{codigo}") void borrar(@PathVariable String codigo) {
		//repositori.remove(eli);
		itemRepository.findById(codigo).orElseThrow(() -> new RegistroNoEncontradoExeception());
		itemRepository.deleteById(codigo);
		
		
	}
	

		@PutMapping ()
		public void actualizar( @RequestBody Producto Producto) {
			
			itemRepository.findById(Producto.getCodigo()).orElseThrow(() -> new RegistroNoEncontradoExeception());
			itemRepository.save(Producto);

		}
	
	
}
