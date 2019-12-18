package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dominio.service.FacturaService;
import com.example.demo.dominio.service.ProductoService;
import com.example.demo.infraestructura.dto.FacturaDto;
import com.example.demo.infraestructura.dto.FacturaRest;
import com.example.demo.infraestructura.dto.ItemDto;
import com.example.demo.infraestructura.dto.ItemRest;
import com.example.demo.infraestructura.dto.ProductoDto;
import com.example.demo.infraestructura.dto.ProductoRest;
import com.example.demo.infraestructura.mapper.FacturaMapper;
import com.example.demo.infraestructura.mapper.ProductoMapper;
import com.example.demo.infraestructura.repository.database.FacturaRepository;
import com.example.demo.infraestructura.repository.database.ProductoRepository;
import com.example.demo.shared.dominio.Id;


@RestController
@RequestMapping("/factura")
public class FacturaControllers {
	
	@Autowired
	private FacturaRepository  facturaRepository;
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private FacturaMapper facturaMapper;
	@Autowired
	private FacturaService facturaService;
	@Autowired
	private ProductoMapper productoMapper;
	@Autowired
	private ProductoService productoService;
	

	
	@PostMapping()
	void crearFactura(@RequestBody FacturaRest factura) {
		Random rnd =new Random();
		FacturaRest f = factura;
		f.setId((Math.abs(rnd.nextLong())%100));
		f.setItems(this.cargarItemRests(f.getItems()));
		f.setValor_total(this.calcularFactura(f.getItems()));
		f.setNombre_cliente("sds");

		facturaService.guardad(facturaMapper.dtoDominio(f));
	}

	@GetMapping()
	public List<FacturaDto>consultar(){
		//return facturaRepository.findAll();
		
		return facturaService.buscartodo().stream().map(factura -> facturaMapper.dominiodtoapi(factura)).collect(Collectors.toList());
	}
	

	public List<ItemRest> cargarItemRests(List<ItemRest> list){
		
		List<ProductoRest> productos= cargarProductos(obtenerCodigos(list));
		
		list.stream().forEach(
				item ->{ item.setProductoRest(cargarProducto(productos, item.getId()));
				item.setValor_total(item.getCantidad()*item.getProductoRest().getValor());
				}		
				);
	
		return list;
		
	}


	public Float calcularFactura(List<ItemRest> list) {
		Float v = (float) 0.0;
		for (ItemRest i : list) {
			v = v + (i.getCantidad() * i.getProductoRest().getValor());
		}
		return v;
	}
	
	public List<Long> obtenerCodigos(List<ItemRest> list) {

		return list.stream().map(item -> item.getProductoRest().getId()).collect(Collectors.toList());
	}
	
	public ProductoRest cargarProducto(List<ProductoRest> productos, Long id) {
		ProductoRest producto = new ProductoRest();
		for (ProductoRest pro : productos) {
			producto.setId(pro.getId());
			producto.setCodigo(pro.getCodigo());
			producto.setNombre(pro.getNombre());
			producto.setValor(pro.getValor());
		}
		return producto;
	}

	public List<ProductoRest> cargarProductos(List<Long> id) {
		ArrayList<Id> consulta = new ArrayList<>();
		for (Long llega : codigos) {
			consulta.add(new Id(llega));
		}

		return productoMapper.dominiodto(productoService.buscarPorIds(consulta));
	}
}
