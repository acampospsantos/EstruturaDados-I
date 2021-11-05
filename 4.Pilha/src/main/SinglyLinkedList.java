package com.diegopinheiro.estruturadados1.list04;

//É uma Lista Simplismente Encadeada de elementos genéricos que extendem Item
//Lista Simplismente Encadeada - GENÉRICA

public class SinglyLinkedList <T extends Item> {
	private SinglyListNode<T> head;
//	private t size;
	
	//Método Construtor
	public SinglyLinkedList() {
		this.head = null;
	//	this.size = 0;
	}
	
	
	//Métodos Acessores e Modificadores
	public void setHead(SinglyListNode<T> headd) {
		this.head = headd;
	}
	public SinglyListNode<T> getHead(){
		return this.head;
	}
	
	 
	//Métodos da Classe
	
	public boolean isEmpty() {		
		//if(this.head==null){
		//    return true;
		//} else {
		//    return false;
		//}
		return this.head == null; //Se o primeiro nó da lista for 0, a lista é null
	}
	
	public void addFirst(T item) {
		SinglyListNode<T> newHead = new SinglyListNode<T>(item, this.getHead());  
		this.setHead(newHead);
		//newHead.next = oldHead
	}
	
public SinglyListNode<T> search (T i) { //i = elemento procurado //Função retorna o Nó procurado			
		
		if (isEmpty()) { //Caso a lista esteja vazia
			return null;
		} else { //Caso a Lista NÃO esteja vazia
			
			SinglyListNode<T> result = this.head; //Variável auxiliar: que vai retornar o Nó procurado
			SinglyListNode<T> NODE = this.head; //Variável auxiliar GERAL
			
			if (this.head.getItem() == i) { //Se o elemento procurado for o primeiro Nó
				NODE = this.head;
				result = NODE; 				
			} else { //Se o elemento procurado NÃO for o primeiro Nó
				//ListNode NODE = this.head;								 
				 while (NODE != null) {
					if (NODE.getItem() == i) {
						result = NODE;						
						break;						
					}
					NODE = NODE.getNext();
				 }				 
			}
			if (result != NODE) { //Se result NÃO for == NODE
				result = null;
			}
			return result;			
		}				
	}

public int size() { //Retorna tamanho da lista
	int contador = 0;
	if (this.getHead() == null) {
	   //contador = 0;
	} else {
		SinglyListNode<T> aux = this.head;
		while(aux != null) {
			aux = aux.getNext(); 
			contador = contador + 1;
		}
	}
	return contador;
}


public void addLast(T item) {
	SinglyListNode<T> LastNo = new SinglyListNode<T>(item, null);//Nó que vai ser adicionado na úlltima posição da Lista
	if (this.head == null) { //Se a lista for null
		this.head = LastNo;								
	} else {
		SinglyListNode<T> node = this.head;   //Nó auxiliar 
		while(node.getNext() != null) {
			 node = node.getNext();				
		}
		//Quando chegar no último Nó (null) o LastNo é colocado na Lista
		node.setNext(LastNo); //node.next = LastNo;
		//LastNo.next = null; //(Óbvio: é vazio depois do Nó adicionado no fim da Lista)			
	}
}

public void reverse() { //reverte ordem dos itens da lista
	if (this.isEmpty()) { //Caso lista esteja vazia
		return ;
	} 
	SinglyListNode<T> a = this.head.getNext();
	SinglyListNode<T> b = this.head;		
   
	SinglyListNode<T> temp = this.head.getNext().getNext(); //Variável auxiliar temporária
	while(a != null) {
		temp = a.getNext();
		a.setNext(b);
		b = a;
		a = temp;
	}
	this.head.setNext(null);
	this.head = b;
}

public void delete(SinglyListNode<T> deleteNode){  //Função deleta um Nó
	if (isEmpty()) { //Caso lista esteja vazia
		return ;
	}
	
	if (this.head == deleteNode) { //Caso seja o primeiro nó
		this.head = this.head.getNext();
	} else { //Caso não seja o primeiro Nó
		SinglyListNode<T> node = this.head; 
		while (node.getNext() != null) {
			if (node.getNext().getItem().equals(deleteNode.getItem())) {
				node.setNext(node.getNext().getNext());		
				break;
			}
			node = node.getNext();
		}		
	}

}
}