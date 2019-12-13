package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Factura;
import com.example.demo.dto.Item;
import com.example.demo.dto.Producto;
import com.example.demo.repository.FacturaRepository;
import com.example.demo.repository.ProductoRepository;


@RestController
@RequestMapping("/factura")
public class FacturaControllers {
	
	@Autowired
	private FacturaRepository  facturaRepository;
	@Autowired
	private ProductoRepository productoRepository;
	

	
	@PostMapping()
	void crearFactura(@RequestBody Factura factura) {
		List<String> codigos = new ArrayList();
		for (Item item : factura.getList()) {
			codigos.add(item.getProducto().getCodigo());
		}
		List<Item> guardarEnFactura = new ArrayList();
		List<Producto> productos = productoRepository.findAllById(codigos);
		float vT = 0;
		for (Item item : factura.getList()) {
			for (Producto pro : productos) {
				if (pro.getCodigo().equals(item.getProducto().getCodigo())) {
					item.setProducto(pro); 
					item.setValor_total(item.getCantidad()*pro.getValor());
					vT = vT + (item.getCantidad() * pro.getValor());
					guardarEnFactura.add(item);
				}
			}
		}
		factura.setValor_total(vT);
		factura.setList(guardarEnFactura);
		facturaRepository.save(factura);

	}

	@GetMapping("/factura")
	public List<Factura>consultar(){
		return facturaRepository.findAll();
	}
	

}
