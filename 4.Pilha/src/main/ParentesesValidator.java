package com.diegopinheiro.estruturadados1.list04;


public class ParentesesValidator {

	//Atributos da Classe (Encapsulados)
	private ExpressionItem[] openCharacters;
	private ExpressionItem[] closeCharacters;
	
	public ParentesesValidator() {
		String[] openCharacters = {"(", "[", "{"};
		
		int lengthOpen = openCharacters.length;
		this.openCharacters = new ExpressionItem[lengthOpen ];
		for (int i = 0; i < lengthOpen ; i++) {
			this.openCharacters[i] = new ExpressionItem(openCharacters[i]);
		}
		
		String[] closeCharacters = {")", "]", "}"};
		
		int lengthClose = closeCharacters.length;
		this.closeCharacters = new ExpressionItem[lengthClose];
		for (int i = 0; i < lengthClose ; i++) {
			this.closeCharacters[i] = new ExpressionItem(closeCharacters[i]);
		}
		
	}
	
	public boolean isValid(ExpressionItem[] items) {
		boolean result = true;
		StackSinglyLinkedList<ExpressionItem> list = new StackSinglyLinkedList<ExpressionItem>();
		
		for (ExpressionItem item : items) {
			ExpressionItem currentItem = item;
			if (this.isOpen(currentItem)) {
				list.push(item);
				continue;
			}
			else {
				try {
					ExpressionItem lastItem = list.pop();
					ExpressionItem lastItemOpen = this.getOpen(currentItem);
					if (!lastItem.equals(lastItemOpen)) {
						result = false;
						break;
					}

				} catch (Exception e) {
					result = false;
					break;
				}
			}
			}
			
		
		if (!list.isEmpty()) {
			result = false;
		}
		return result;

	}
	
	private ExpressionItem getOpen(ExpressionItem closeItem) {
		if(closeItem.equals(this.closeCharacters[0])) {
			return this.openCharacters[0];
		}else if (closeItem.equals(this.closeCharacters[1])) {
			return this.openCharacters[1];
		}else if (closeItem.equals(this.closeCharacters[2])) {
			return this.openCharacters[2];
		}else
		{
			throw new RuntimeException();
		}
		
	}
	private boolean isOpen(ExpressionItem c) {
		boolean result = false;
		for (ExpressionItem openCharacter : this.openCharacters) {
			if(c.equals(openCharacter)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	
}
