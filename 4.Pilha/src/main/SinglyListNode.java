package com.diegopinheiro.estruturadados1.list04;

//t(GENERICS) - pode ser qualquer coisa
public class SinglyListNode <T extends Item> {
	//Atributos (encapsulados)
	private T item;
	private SinglyListNode<T> next;
	
	//Método Construtor
	public SinglyListNode(T item, SinglyListNode<T> next) {
		this.item = item;
		this.next = next;
	}
	
	//Métodos Acessores e Modificadores
	public void setItem(T itemm) {
		this.item = itemm;
	}
	public T getItem() {
		return this.item;
	}
	
	public void setNext(SinglyListNode<T> nextt) {
		this.next = nextt;
	}
	public SinglyListNode<T> getNext(){
		return this.next;
	}
	
	

}
