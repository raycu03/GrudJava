package com.example.demo.infraestructura.repository.adapters;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.model.Factura;
import com.example.demo.dominio.model.Item;
import com.example.demo.dominio.service.FacturaService;
import com.example.demo.infraestructura.dto.FacturaRest;
import com.example.demo.infraestructura.mapper.FacturaMapper;
import com.example.demo.infraestructura.repository.database.FacturaRepository;

@Service
public class FacturaAdapter implements FacturaService{
	
	@Autowired
	public FacturaRepository facturaRepository;
	
	@Autowired
	public FacturaMapper facturaMapper;

	@Override
	public void guardad(Factura factura) {
		facturaRepository.save(facturaMapper.dominiodtoapi(factura));
		
	}

	@Override
	public Factura buscar(Long id) {
		return facturaMapper.dtoDominioapi(facturaRepository.findById(id).get());
		 
	}

	@Override
	public List<Factura> buscartodo() {
	
		return facturaMapper.dtoDominioapi(facturaRepository.findAll());
	}

	@Override
	public void borrar(Long id) {
		
		facturaRepository.deleteById(id);
	}

	@Override
	public void actualizar(Factura factura) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
