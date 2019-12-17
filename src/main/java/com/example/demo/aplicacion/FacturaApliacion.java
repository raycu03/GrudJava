package com.example.demo.aplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dominio.service.ProductoService;
import com.example.demo.infraestructura.dto.FacturaDto;
import com.example.demo.infraestructura.dto.ItemDto;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.infraestructura.repository.database.FacturaRepository;
import com.example.demo.infraestructura.repository.database.ProductoRepository;

@Component
public class FacturaApliacion {
	
	@Autowired
	private FacturaRepository  facturaRepository;
	@Autowired
	private ProductoRepository productoRepository;
	

	

	void crearFactura(FacturaDto factura) {
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


	public List<FacturaDto>consultar(){
		return facturaRepository.findAll();
	}
	
	
}
