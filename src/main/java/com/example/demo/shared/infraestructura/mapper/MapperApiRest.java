package com.example.demo.shared.infraestructura.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperApiRest  <I, O>{
	
	public I recibir(O o);
	public O convertir(I i);
	
	public default List<O> convertir(List<I> instancias){
		return instancias.stream().map(this::convertir).collect(Collectors.toList());
	}
	public default List<I> recibir(List<O> instancias){
		return instancias.stream().map(this::recibir).collect(Collectors.toList());
	}

}
