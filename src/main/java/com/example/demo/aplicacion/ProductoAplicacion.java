package com.example.demo.aplicacion;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dominio.model.Producto;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.mapper.ProductoMapper;



public class ProductoAplicacion {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ProductoMapper productoMapper;
	
	
	@GetMapping()
	List<ProductoDto> consultar(){
		return productoService.buscarTodo().stream().map(producto -> productoMapper.apiconvertir(producto)).collect(Collectors.toList());
		
	}
	

	 public String crear ( ProductoDto producto) {
		Random rnd =new Random();
		producto.setId(Math.abs(rnd.nextLong())%100);
		System.out.print("valor: "+producto.getId());
		productoService.guardar(productoMapper.apirecibir(producto));
		
		return ("dato guardado");
		
	}
	
	public ProductoDto buscar( Long id) {
		
		return productoMapper.apiconvertir(productoService.buscarXId(id));
			
	}

	 public String borrar( Long id) {

		productoService.borrar(id);
		return ("dato borrado");
		
	}
	
		
		public void actualizar( ProductoDto producto) {
			
//			productoRepository.findById(producto.getId()).orElseThrow(() -> new RegistroNoEncontradoExeception());
//			productoRepository.save(producto);
			productoMapper.apiconvertir(productoService.buscarXId(producto.getId()));
			productoService.actualizar(productoMapper.apirecibir(producto));
			//productoMapper.convertir(productoService.actualizar(producto));
			
			
			
		}
		
		


}
