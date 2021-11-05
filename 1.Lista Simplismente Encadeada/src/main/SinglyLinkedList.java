package com.diegopinheiro.estruturadados1.list01;

public class SinglyLinkedList { //Classe LISTA SIMPLISMENTE ENCADEADA (LSE)
	
	//Atributos da Classe
	private ListNode head; //first node	
    private int size; //Quantidade de Nós da Lista
	
	//Método Construtor
	public SinglyLinkedList() {
		this.head = null; //Lista inicializa Null		
		this.size = 0; //Lista inicializa Null
	}
	
	
	//Métodos Acessores e Modificadores (getters e setters)
	public void setHead(ListNode head) {
		this.head = head;	
	}
	
	public ListNode getHead() {
		return this.head;
	}	
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.size;
	}

	
	//Métodos da Classe (LISTA SIMPLISMENTE ENCADEADA)	
	
	public boolean isEmpty() {		
		return this.head == null; //Se a cabeça da lista for 0, a lista é null
	}

	
	public void addFirst(int i) {		
		 ListNode novoNo = new ListNode(i, head); //Novo nó
		// novoNo.nextNode = head; // Esse código já tá na Classe Nó
		 this.head = novoNo; //A cabeça da Lista vira Novo Nó
		 this.setSize(this.getSize() + 1); 
	}
	
	
	public ListNode search (int i) { //i = elemento procurado //Função retorna o Nó procurado			
		
		if (isEmpty()) { //Caso a lista esteja vazia
			return null;
		} else { //Caso a Lista não esteja vazia
			
			ListNode result = this.head; //Variável auxiliar: que vai retornar o Nó procurado
			ListNode NODE = this.head; //Variável auxiliar GERAL
			
			if (this.head.getData() == i) { //Se o elemento procurado for o primeiro Nó
				NODE = this.head;
				result = NODE; 				
			} else { //Se o elemento procurado não for o primeiro Nó
				//ListNode NODE = this.head;								 
				 while (NODE != null) {
					if (NODE.getData() == i) {
						result = NODE;						
						break;						
					}
					NODE = NODE.getNext();
				 }
				 
			}
			if (result != NODE) { //Se result não for == NODE
				result = null;
			}
			return result;			
		}		
		
	}

	
	
	public int size() { //Retorna tamanho da lista
		return this.getSize();
	}
	
	
	public boolean isOrdered(boolean ascending) {		
		boolean resp = true;
		if (this.head == null || this.head.getNext() == null) { //Se a lista tiver vazia ou se tiver só um Nó
			resp = true;
		} else {
			ListNode a = this.head;
			
			if (ascending == true) {
				while (a.next != null) {
					if (a.next.getData() > a.getData()) {
						a = a.next;
					} else {
						resp = false;
						break;
					}				
				}
			} else { //ascending == false
				while (a.next != null) {
					if (a.next.getData() < a.getData()) {
						a = a.next;
					} else {
						resp = false;
						break;
					}				
				}
			}				
		}
		return resp;
	}
	
		
	public void addLast(int elem) {
		ListNode LastNo = new ListNode(elem, null);//Nó que vai ser adicionado na última posição da Lista
		if (this.head == null) { //Se a lista for null
			this.head = LastNo;			
			this.setSize(this.getSize() + 1);					
		} else {
			ListNode node = this.head;   //Nó auxiliar 
			while(node.getNext() != null) {
				 node = node.getNext();				
			}
			//Quando chegar no último Nó (null) o LastNo é colocado na Lista
			node.setNext(LastNo); //node.next = LastNo;
			//LastNo.next = null; //(Óbvio: é vazio depois do Nó adicionado no fim da Lista)
			this.setSize(this.getSize() + 1);
		}
	}
	
	
	public void reverse() { //reverte ordem dos itens da lista
		if (this.isEmpty()) { //Caso lista esteja vazia
			return ;
		} 
		ListNode a = this.head.next;
		ListNode b = this.head;		
	   
		ListNode temp = this.head.next.next; //Váriavel auxiliar temporária
		while(a != null) {
			temp = a.next;
			a.setNext(b);
			b = a;
			a = temp;
		}
		this.head.next = null;
		this.head = b;
	}
	
	
	public void delete(ListNode deleteNode){  //Função deleta um Nó
		if (isEmpty()) { //Caso lista esteja vazia
			return ;
		}
		
		if (this.head == deleteNode) { //Caso seja o primeiro nó
			this.head = this.head.getNext();
		} else {
			ListNode node = this.head; //Variável node (HEAP) criada AGORA
			while (node.next != null) {
				if (node.getNext().getData() == deleteNode.getData()) {
					node.setNext(deleteNode.getNext());		
					break;
				}
				node = node.getNext();
			}
		}
	}		
			
}
		
		

			

		
				



