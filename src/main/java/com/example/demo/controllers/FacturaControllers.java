package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.infraestructura.dto.Factura;
import com.example.demo.infraestructura.dto.ItemDto;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.repository.database.ProductoRepository;
import com.example.demo.repository.FacturaRepository;


@RestController
@RequestMapping("/factura")
public class FacturaControllers {
	
	@Autowired
	private FacturaRepository  facturaRepository;
	@Autowired
	private ProductoRepository productoRepository;
	

	
	@PostMapping()
	void crearFactura(@RequestBody Factura factura) {
		List<Long> codigos = new ArrayList();
		for (ItemDto item : factura.getList()) {
			codigos.add(item.getProducto().getId());
		}
		List<ItemDto> guardarEnFactura = new ArrayList();
		List<ProductoDto> productos = productoRepository.findAllById(codigos);
		float vT = 0;
		for (ItemDto item : factura.getList()) {
			for (ProductoDto pro : productos) {
				if (pro.getId().equals(item.getProducto().getId())) {
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

	@GetMapping()
	public List<Factura>consultar(){
		return facturaRepository.findAll();
	}
	

}
