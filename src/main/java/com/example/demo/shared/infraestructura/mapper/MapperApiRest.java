package com.example.demo.shared.infraestructura.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface MapperApiRest  <I, O>{
	
	public I dtoDominioapi(O o);
	public O dominiodtoapi(I i);
	
	public default List<O> dominiodtoapi(List<I> instancias){
		return instancias.stream().map(this::dominiodtoapi).collect(Collectors.toList());
	}
	public default List<I> dtoDominioapi(List<O> instancias){
		return instancias.stream().map(this::dtoDominioapi).collect(Collectors.toList());
	}

}
