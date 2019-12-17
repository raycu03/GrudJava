package com.example.demo.dominio.service;

import java.util.List;

import com.example.demo.dominio.model.Factura;
import com.example.demo.dominio.model.Item;

public interface FacturaService {
	

	public void guardad(Factura factura);
	public Factura buscar(Long id);
	public List<Factura> buscartodo();
	public void borrar(Long id);
	public void actualizar(Factura factura);
	

}
