package com.diegopinheiro.estruturadados1.list04;

import org.junit.Assert;
import org.junit.Test;

public class TestStackSingly {
	
	@Test
	public void testPushPop() {
		StackSinglyLinkedList<Conta> stack = new StackSinglyLinkedList<>();
		Assert.assertTrue(stack.isEmpty());
		
		stack.push(new Conta("1"));
		Assert.assertFalse(stack.isEmpty());
		
		stack.push(new Conta("2"));
		
		Conta c;
		String expectedId;
		String actualId;
		
		try {
			c = stack.pop();
			expectedId = "2";
			actualId = c.getId();
			Assert.assertEquals(expectedId, actualId);
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
		try {
			c = stack.pop();
			expectedId = "1";
			actualId = c.getId();
			Assert.assertEquals(expectedId, actualId);
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
		Assert.assertTrue(stack.isEmpty());
	}
	
	
	@Test
	public void testPopEmptyStack() {
		StackSinglyLinkedList<Conta> stack = new StackSinglyLinkedList<>();
		Assert.assertTrue(stack.isEmpty());
		
		try {
			Conta c;
			c = stack.pop();
			Assert.fail("Stack is empty");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		
		
	}
}
