package com.diegopinheiro.estruturadados1.list03;

public class CircularLinkedList {
	
	    //Atributos(Encapsulado)
		private ListNode sentinel; //Sentinela da Lista
		
		//Método Construtor
		public CircularLinkedList() { 
			this.sentinel = new ListNode (0, null, null); //Instância da Sentinela //Parâmetros nulos
			this.sentinel.setNext(this.sentinel);
			this.sentinel.setPrevious(this.sentinel);			
		}
		
		//Métodos Acessores e Modificadores(getters e setters)
		public ListNode getHead() {
			return this.sentinel.getNext();
		}
		
		public ListNode getTail() {
			return this.sentinel.getPrevious();
		}		
		
		
				
		
		//Métodos da Classe (Lista Encadeada Circular)
		
		public boolean isEmpty() {
			boolean result = false;
			if (this.sentinel.getNext() == this.sentinel && this.sentinel.getPrevious() == this.sentinel) { 
				//Se o próximo && o anterior da Sentila for a própria sentila.. ent lista = vazia
				result = true;
			} else {
				result = false;
			}
			return result;
		}
		
		
		public void addFirst(int i) {
			ListNode newHead = new ListNode(i, this.getHead(), this.sentinel);
			this.sentinel.getNext().setPrevious(newHead);
			this.sentinel.setNext(newHead);
			//newHead.next = *old head*;
			//newHead.previous = this.sentinel; 
		}
		
		
		public ListNode search(int i) {			
			if (isEmpty()) { //Se a Lista for vazia
				return null;
			} else {//Se a lista !vazia
				ListNode aux = this.sentinel.getNext();
				ListNode result = this.sentinel.getNext();
				while (aux != this.sentinel) {
					if (aux.getData() == i) {
						result = aux;
						break;
					}
					aux = aux.getNext();
				}
				if (result != aux) {
					result = null;
				}
				return result;
			}			 			
		}
		
		
		public int size() {
			int contador = 0;
			if (this.sentinel.getNext() == this.sentinel && this.sentinel.getPrevious() == this.sentinel) { //Se a lista estiver vazia
				contador = 0;
			} else { //!Lista vazia
				ListNode aux = this.sentinel.getNext();
				while (aux != this.sentinel) {
					aux = aux.getNext();
					contador = contador + 1;
				}	
			}	
			return contador;
		}
		
		
		public void addLast(int i) {
			ListNode lastNode = new ListNode(i, this.sentinel, this.getTail());
			this.getTail().setNext(lastNode);
		    this.sentinel.setPrevious(lastNode);
		    //lastNode.next = this.sentinel;
		    //lastNode.previus = *old tail*;
		}
		
		
		public boolean isOrdered(boolean ascending) {
			boolean result = true;
			if ( (this.sentinel.getNext() == this.sentinel && this.sentinel.getPrevious() == this.sentinel) || this.getHead().getNext() == null) {
			//Se a Lista Circular estiver (vazia) ou se tiver (apenas um Nó):....					
				result = true;
			} else { //Lista tem mais de um Nó
				ListNode aux = this.sentinel.getNext();
				
				if (ascending == true) { //Crescente					
					while(aux.getNext() != this.sentinel) {
						if (aux.getNext().getData() < aux.getData()) {
							result = false;
							break;
						}
						aux = aux.getNext();
					}		
					
				} else { //ascending == false //Descrescente					
					while(aux.getNext() != this.sentinel) {
						if (aux.getNext().getData() > aux.getData()) {
							result = false;
							break;
						}
						aux = aux.getNext();
					}					
				}						
			}
			return result;
		}		
		
		
		public void reverse() {			
		
		}
		
		
		public void delete(ListNode nodeDelete) {
			if (isEmpty()) {//Lista vazia
				return ;
			}
			if (nodeDelete.getPrevious() != sentinel) { //Se o Nó NÃO for a cabeça da Lista
				nodeDelete.getPrevious().setNext(nodeDelete.getNext());
			} else { //Se for o primeiro Nó da Lista
				this.sentinel.setNext(nodeDelete.getNext());
			}
			if (nodeDelete.getNext() != sentinel) { //Se o Nó NÃO for a calda da Lista
				nodeDelete.getNext().setPrevious(nodeDelete.getPrevious());
			} else { //Se for o último Nó da Lista
				this.sentinel.setPrevious(nodeDelete.getPrevious());			
			}			
		}		
		
		
		
		//2º QUESTÃO
 		public CircularLinkedList copy() {
 			CircularLinkedList listCopy = new CircularLinkedList(); //Lista Cópia
 			if (isEmpty()) { //Se a List for null
				//ListCopy continua vazia
			} else { //Se a list != null
				ListNode aux1 = this.sentinel.getNext();//variável recebe a head da lista
				while (aux1 != this.sentinel) { 
					listCopy.addLast(aux1.getData());
					aux1 = aux1.getNext();					
				}
			}
			return listCopy;
		}
// 		|
// 		V
 		// ...} else {                                                          |   ...} else {
 		//      ListNode aux1 = list.sentinel.getPrevious();                    |         ListNode aux1 = list.sentinel.getNext();
 		//      while (aux1 != this.sentinel) {                                 |         while (aux1 != this.sentinel) {
 		//            listCopy.addFirst(aux1.getData());                        |               listCopy.addFirst(aux1.getData());
  		//            aux1 = aux1.getPrevious();                                |               aux1 = aux1.getNext();
 		//     }                                                                |         }
		//                                                                      |         listCopy.reverse();
		
 		
 		
 		//3º QUESTÃO
		public boolean isEquals(CircularLinkedList list) { //se a lista for igual = true | se a lista for!igual = false
			boolean result = true;
			if (size() == list.size()) { //Listas têm mesmo tamanho
				if (this.sentinel.getNext() != this.sentinel) {//Se a lista !for null
					ListNode aux1 = this.getHead();
					ListNode aux2 = list.getHead();
					while(aux1 != this.sentinel) {
						if (!aux1.equals(aux2)) { //Se o Nó das listas comparadas !forem iguais
							result = false;
							break;
						}
						aux1 = aux1.getNext();
						aux2 = aux2.getNext();
						//result = true
					}
				} else { //Se as listas forem null //this.sentinel.getNext() = this.sentinel;
					result = true;
				}				
			} else { //Se as listas tem tamanhos diferentes
				result = false;
			}
			return result;
		}

		
				
		//4º Questão   
		public int get (int index) {	
		
		 int resp = 0;			  
		 try {
			  int contador = 1;
			  if (size() >= index) {
				  ListNode aux = this.sentinel.getNext();				 
				  while (aux != this.sentinel) {
					  if(contador == index) {
						  resp = aux.getData();
						  break;
					  }
					  aux = aux.getNext();
					  contador = contador + 1;
				  }
				  
			  } else if (size() < index) {
				  //## Continuar circulando a lista ##
				  //## DICA: PULAR A SENTINELA ##
				  ListNode auxiliar = this.sentinel.getNext();						  
				
				 do {
					 auxiliar = auxiliar.getNext();
					 contador = contador + 1;					 
				 } while (contador != index) ;							
					resp = auxiliar.getData();						
			}		 
			  
		 } catch(AssertionError listaVazia) { //Captura da Possível Exceção
			 //Tratamento da Excessão
			 System.out.println("List is Empty");
			 resp = 0;
		 }		  
		  return resp;		 
	   }
}
		
				


		
	

		

