package com.diegopinheiro.estruturadados1.list04;

//A classe conta herda Item
public class Conta extends Item {
	private String id;

	
	//Método Construtor
	public Conta(String i) {
		this.id = i;
	}
	
	//Método implementado de Item
	@Override
	public String getId() {
		return id;
	}

}
