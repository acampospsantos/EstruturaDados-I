package com.diegopinheiro.estruturadados1.list04;

import org.junit.Assert;
import org.junit.Test;



public class TestParenthesesValidator {

	@Test
	public void testParentheses0() {
		ParentesesValidator parenthesesValidator = new ParentesesValidator();
		
		String[] characters = {};
		ExpressionItem[] items = new ExpressionItem[characters.length];
		for(int i = 0; i < characters.length; i++) {
			items[i] = new ExpressionItem(characters[i]);
		}
		
		boolean actual = parenthesesValidator.isValid(items);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	
	@Test
	public void testParentheses1() {
		ParentesesValidator parenthesesValidator = new ParentesesValidator();
		
		String[] characters = {"(", ")"};
		ExpressionItem[] items = new ExpressionItem[characters.length];
		for(int i = 0; i < characters.length; i++) {
			items[i] = new ExpressionItem(characters[i]);
		}
		
		boolean actual = parenthesesValidator.isValid(items);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testParentheses2() {
		ParentesesValidator parenthesesValidator = new ParentesesValidator();
		
		String[] characters = {"(", ")", "[", "]", "{", "}"};
		ExpressionItem[] items = new ExpressionItem[characters.length];
		for(int i = 0; i < characters.length; i++) {
			items[i] = new ExpressionItem(characters[i]);
		}
		
		boolean actual = parenthesesValidator.isValid(items);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testParentheses3() {
		ParentesesValidator parenthesesValidator = new ParentesesValidator();
		
		String[] characters = {"(", "[","{", "}", "]", ")"};
		
		ExpressionItem[] items = new ExpressionItem[characters.length];
		for(int i = 0; i < characters.length; i++) {
			items[i] = new ExpressionItem(characters[i]);
		}
		
		boolean actual = parenthesesValidator.isValid(items);
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testParentheses4() {
		ParentesesValidator parenthesesValidator = new ParentesesValidator();
		
		String[] characters = {")"};
		ExpressionItem[] items = new ExpressionItem[characters.length];
		for(int i = 0; i < characters.length; i++) {
			items[i] = new ExpressionItem(characters[i]);
		}
		
		boolean actual = parenthesesValidator.isValid(items);
		boolean expected = false;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testParentheses5() {
		ParentesesValidator parenthesesValidator = new ParentesesValidator();
		
		String[] characters = {"(", "[","}", "]"};
		ExpressionItem[] items = new ExpressionItem[characters.length];
		for(int i = 0; i < characters.length; i++) {
			items[i] = new ExpressionItem(characters[i]);
		}
		
		boolean actual = parenthesesValidator.isValid(items);
		boolean expected = false;
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testParentheses6() {
		ParentesesValidator parenthesesValidator = new ParentesesValidator();
		
		String[] characters = {"(", "[","]", ")", "{"};
		ExpressionItem[] items = new ExpressionItem[characters.length];
		for(int i = 0; i < characters.length; i++) {
			items[i] = new ExpressionItem(characters[i]);
		}
		
		boolean actual = parenthesesValidator.isValid(items);
		boolean expected = false;
		Assert.assertEquals(expected, actual);
	}
}
