package com.example.demo.shared.dominio;

import com.example.demo.exeptions.RangoExeception;

public class Id {

	private final Long id;
	public Id(Long id) {

		this.id = id;
		if (id>99999) {
			
			throw new RangoExeception();
		}
		
		
	}
	public Long getId() {
		return id;
	}
	

}
