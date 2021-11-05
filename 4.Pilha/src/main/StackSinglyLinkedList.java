package com.diegopinheiro.estruturadados1.list04;

public class StackSinglyLinkedList <T extends Item> implements IStack<T> {
	//Atributos (da Classe 'Lista Simplesmente Encadeada com Pilha')
	private SinglyLinkedList<T> list;
	
	
	//Método Construtor
	public StackSinglyLinkedList() {
	//	this.list = new SinglyLinkedList<T>(); (Código do Prof)
		SinglyLinkedList<T> Lista = new SinglyLinkedList<T>();
		this.list = Lista;
	}
	
	
	//Implementando os métodos da Interface (Sobrescrever - Override)
	
	//Empilha
	@Override
	public void push (T item) {
		this.list.addFirst(item);
	}
	
	//Desempilha 
	@Override
	public T pop() { //Retorna oq tem dentro do topo que foi retirado (Tipo genérico)
		SinglyListNode<T> oldTop = this.list.getHead();
		T result = this.list.getHead().getItem();
		if (this.list.isEmpty() != true) {			
			this.list.delete(oldTop);
			result = oldTop.getItem();
		} else {
			//Lista tá vazia, Topo tem nada
			result = null;
		}
		return result;
	}
	
	//Verifica se a Pilha está vazia
	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}	
	

}
