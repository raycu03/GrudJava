package com.example.demo.shared.infraestructura.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperApiRest  <I, O>{
	
	public I apirecibir(O o);
	public O apiconvertir(I i);
	
	public default List<O> apiconvertir(List<I> instancias){
		return instancias.stream().map(this::apiconvertir).collect(Collectors.toList());
	}
	public default List<I> apirecibir(List<O> instancias){
		return instancias.stream().map(this::apirecibir).collect(Collectors.toList());
	}

}
