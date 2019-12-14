package com.example.demo.shared.dominio;

import com.example.demo.exeptions.RangoExeception;

public class Id {

	private final Long value;
	public Id(Long id) {

		this.value = id;
		if (id>99999) {
			
			throw new RangoExeception();
		}
		
		
	}
	public Long getValue() {
		return value;
	}
	

}
