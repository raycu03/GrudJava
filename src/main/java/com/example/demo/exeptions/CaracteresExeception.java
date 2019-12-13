package com.example.demo.exeptions;

public class CaracteresExeception extends RuntimeException{
	
	public CaracteresExeception() {
		super(" cantidad de caracteres invaldia");
	}

}
