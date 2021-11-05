package com.diegopinheiro.estruturadados1.list02;

public class DoublyLinkedList { //Classe LISTA DUPLAMENTE ENCADEADA (LDE)
	
	   //Atributos da Lista (Encapsulados)
		private ListNode head; //Primeiro Nó
		private ListNode tail; //Último Nó		
		
		//Método Construtor
		public DoublyLinkedList() { //Primeiro/Último Nó = Vazio
			this.head = null;
			this.tail = null;			
		}
		
		//Métodos Acessores e Modificadores(getters e setters)
		public void setHead(ListNode head) {
			this.head = head;
		}
		public ListNode getHead() {
			return this.head;
		}
		
		public void setTail(ListNode tail) {
			this.tail = tail;
		}
		public ListNode getTail() {
			return this.tail;
		}		
		
		
		//Métodos da Classe (Lista Duplamente Encadeada)
		
		public boolean isEmpty() { //Vazia = return true | !Vazia = return false
			boolean result;
			if (this.head == null && this.tail == null) {
				result = true; //Lista está vazia
			} else {
				result = false;//Lista NÃO está vazia
			}
			return result;
		}
		
		
		public void addFirst(int i) { //adiciona um nó no início da Lista			
			ListNode firstNode = new ListNode(i, this.head, null); //Novo nó
			//firstNode.next = this.head //Isso já tá na classe ListNode
			//firstNode.previous = null; //...
			if (isEmpty()) { //Se a lista for null				
				this.head = firstNode;
				this.tail = firstNode;					
			} else {				
				this.head.setPrevious(firstNode);
				this.head = firstNode;				
			}			
		}
		
		
		public ListNode search(int i) { //Procura um Nó e retorna o Nó procurado
			if (isEmpty()) { //Caso esteja Vazia
				return null;
			} else { //Caso a lista não esteja Vazia
				
				ListNode result = this.head; //Variável auxiliar: que vai retornar o Nó procurado
				ListNode NODE = this.head; //Variável auxiliar GERAL
				
				if(this.head.getData() == i) {
					 NODE = this.head;
					 result = NODE;
				} else {
					//ListNode NODE = this.head;
					while (NODE != this.tail.getNext()) { //NODE != Null
						if(NODE.getData() == i) {
							result = NODE;
							break;
						}
						NODE = NODE.getNext();
					}
				}
				if (result != NODE) {
					result = null;
				}
				return result;
			}
			
		}
		
		
		public int size() { //Retorna tamanho da lista
			int contador = 0;
			if (this.getHead() == null) { //Se a lista for vazia
				contador = 0;
			} else { //Se a lista !for vazia
				ListNode aux = this.head;
				while(aux != null) {
					aux = aux.getNext(); 
					contador = contador + 1;
				}
			}
			return contador;
		}
		
		
		public void addLast(int i) {//adiciona um nó no fim da lista
			ListNode lastNode = new ListNode(i, null, this.tail);
			//lastNode.next = null //Isso já tá na classe ListNode
			//lastNode.previous = this.tail; //...
			if (isEmpty()) { //Se a lista for null
				this.head = lastNode;
				this.tail = lastNode;				
			} else {
				this.tail.setNext(lastNode);
				this.tail = lastNode;				
			}			
		}
		
		
		public boolean isOrdered(boolean ascending) {
			boolean result = true;
			if (this.head == null || this.head.getNext() == null) {//Se a lista for null ou tiver apenas um Nó-> ela já está ordenada
				result = true;
			} else { //Tem mais de um Nó na Lista
				ListNode aux = this.head;
				
				if (ascending == true) { //Ordenação deve ser crescente
					//aux = this.head
					while (aux.getNext() != this.tail.getNext()) {
						if (aux.getNext().getData() > aux.getData()) {
							aux = aux.getNext();	
							//result = true
						} else {
							result = false;
							break;
						}
					}					
					
				} else { //ascending == false //Ordenação deve ser decrescente
					//aux = this.head
					while (aux.getNext() != this.tail.getNext()) {
						if (aux.getNext().getData() < aux.getData()) {
							aux = aux.getNext();	
							//result = true
						} else {
							result = false;
							break;
						}
					}
				}
			}
			return result;
		}
		
		
		
		public void reverse() { //reverte ordem dos itens da lista
			if (this.isEmpty()) { //Caso lista esteja vazia
				return ;
			}
			ListNode a = this.head.getNext();
			ListNode b = this.head;		
		   
			ListNode temp = this.head.getNext().getNext(); //Variável auxiliar temporária
			while(a != null) {
				temp = a.getNext();
				a.setNext(b);
				b = a;
				a = temp;
			}
			this.head.setNext(null);
			this.head = b;
		}
		
		
		public void delete(ListNode nodeDelete) {//Deleta o nó passado como parâmetro
			if (isEmpty()) {//Lista vazia
				return ;
			}
			if (nodeDelete.getPrevious() != null) { //Se o Nó NÃO for a cabeça da Lista
				nodeDelete.getPrevious().setNext(nodeDelete.getNext());
			} else { //Se o Nó for o primeiro da Lista
				this.head = nodeDelete.getNext();
			}
			if (nodeDelete.getNext() != null) { //Se o Nó NÃO for a calda da Lista
				nodeDelete.getNext().setPrevious(nodeDelete.getPrevious());
			} else { //Se o Nó for o último Nó
				this.tail = nodeDelete.getPrevious();			
			}			
			
		}
		
		
		
		public boolean isPalindrome(DoublyLinkedList sequence) { 
			   boolean result = false;
			   if (sequence.getHead() == null) { //Caso a lista fornecida seja null
				   result = false;
			   } else if (sequence.getHead().getNext() == null) { //Caso a lista fornecida só tenha um Nó
				   result = true;
			   } else { //Caso a lista dada tenha mais de um Nó
				   ListNode aux1 = sequence.getHead();
				   ListNode aux2 = sequence.getTail();
				   result = true;

				   while (aux1 != null && aux2 != null) {
					   if (!aux1.equals(aux2)) {
						   result = false;
                           break;
                      }
                      aux1 = aux1.getNext();
                      aux2 = aux2.getPrevious();   					  			   
				   }			   
			   }	   		   
		    	return result;
		   }
}
