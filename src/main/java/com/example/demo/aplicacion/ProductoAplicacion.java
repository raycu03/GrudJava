package com.example.demo.aplicacion;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dominio.model.Producto;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.ProductoMapper;


@Component
public class ProductoAplicacion {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ProductoMapper productoMapper;
	
	
	public List<ProductoRest> consultar(){
		return productoService.buscarTodo().stream().map(producto -> productoMapper.dominiodto(producto)).collect(Collectors.toList());
		
	}
	

	 public String crear ( ProductoRest producto) {
		productoService.guardar(productoMapper.dtoDominio(producto));
		return ("dato guardado");
		
	}
	
	public ProductoRest buscar( Long id) {
		
		return productoMapper.dominiodto(productoService.buscarXId(id));
			
	}

	 public String borrar( Long id) {

		productoService.borrar(id);
		return ("dato borrado");
		
	}
	
		
		public void actualizar( ProductoRest producto) {
			
//			productoRepository.findById(producto.getId()).orElseThrow(() -> new RegistroNoEncontradoExeception());
//			productoRepository.save(producto);
			productoMapper.dominiodtoapi(productoService.buscarXId(producto.getId()));
			productoService.actualizar(productoMapper.dtoDominio(producto));
			//productoMapper.convertir(productoService.actualizar(producto));
			
			
			
		}
		
		


}
