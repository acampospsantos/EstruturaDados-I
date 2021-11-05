package com.diegopinheiro.estruturadados1.list04;

//A classe está herdando Item
public class ExpressionItem extends Item {
	private String character;
	
	
	//Método Construtor
	public ExpressionItem(String character) {
		this.character = character;
	}
	
	
	@Override
	public String getId() {
		return this.character;
	}

}
