package controller;

import model.estrutura.No;
import model.estrutura.CircularDupla;

public class CircularDuplaController{
	public CircularDuplaController(){
		super();
	}
	
	public String teste() throws Exception{
		CircularDupla lista = new CircularDupla();
		
		lista.append(1);
		lista.append(2);
		lista.append(3);
		lista.append(4);
		
		
		
		return lista.toString();
	}
}