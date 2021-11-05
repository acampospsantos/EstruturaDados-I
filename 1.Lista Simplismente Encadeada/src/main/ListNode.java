package com.diegopinheiro.estruturadados1.list01;

public class ListNode {
	
	//Atributos
	int data; //Elemento do Nó
    ListNode next; //Próximo Nó
	
	
	//Método Construtor
	public ListNode(int elem, ListNode next) {
		this.data = elem; //Novo Nó possui elem
		this.next = next; //Nó seguinte
	}
	
	//Métodos Acessores e Modificadores (getters e setters)
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}
	
	
	public void setNext(ListNode no) {
		this.next = no;
	}
	
	public ListNode getNext() {
		return this.next;
	}
	
}
