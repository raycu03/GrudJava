package com.example.demo.shared.infraestructura.mapper;

public interface MapperApiRest  <I, O>{
	
	public I recibir(O o);
	public O convertir(I i);

}
