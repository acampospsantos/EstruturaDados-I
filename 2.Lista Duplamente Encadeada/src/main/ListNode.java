package com.diegopinheiro.estruturadados1.list02;

public class ListNode {
	
	    //Atributos do Nó (Encapsulados)
		private int data; //Informação do Nó
		private ListNode next; //Próximo Nó
		private ListNode previous; //Nó Anterior
		
		
		//Método Construtor
		public ListNode(int data, ListNode next, ListNode previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;				
		}
		
		//Métodos Acessores e Modificadores (getters e setters)
		public void setData (int data) {
			this.data = data;
		}		
		public int getData() {
			return this.data;
		}		
		
		public void setNext(ListNode next) {
			this.next = next;
		}		
		public ListNode getNext() {
			return this.next;
		}		
		
		public void setPrevious(ListNode previous) {
			this.previous = previous;
		}		
		public ListNode getPrevious() {
			return this.previous;
		}
		
		//Override
		@Override 
		public boolean equals (Object obj) {
		   ListNode otherListNode = (ListNode) obj;
		   return this.getData() == otherListNode.getData();
		}

}
