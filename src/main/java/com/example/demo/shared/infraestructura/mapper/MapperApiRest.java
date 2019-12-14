package com.example.demo.shared.infraestructura.mapper;

public interface MapperApiRest  <I, O>{
	
	public I dto(O o);
	public O model(I i);

}
