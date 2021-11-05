package com.diegopinheiro.estruturadados1.list02;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;




public class TestDoublyLinkedList 
{
    
	
	@Test(timeout = 5000)
    public void testEmptyTrue()
    {
        DoublyLinkedList l = new DoublyLinkedList();
        assertTrue(l.isEmpty());
    }
	
	@Test(timeout = 5000)
    public void testEmptyFalse()
    {
		DoublyLinkedList l = new DoublyLinkedList();
        l.addFirst(0);
        assertTrue(!l.isEmpty());
    }
	
	@Test(timeout = 5000)
    public void testAddFirst()
    {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addFirst(i);
        }
        
        ListNode node = l.getTail();
        for (int expected: list_expected  ) {
        	int actual = node.getData();
        	assertEquals(expected, actual);
        	node = node.getPrevious();
        }      
    }
	
	@Test(timeout = 5000)
	public void testSearchEmpty() {
		DoublyLinkedList l = new DoublyLinkedList();
        ListNode expected = null;
        ListNode actual = l.search(1);
        assertEquals(expected, actual);
	}
	
	
	@Test(timeout = 5000)
	public void testSearchNull() {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        ListNode expected = null;
        ListNode actual = l.search(4);
        assertEquals(expected, actual);
	}
	
	@Test(timeout = 5000)
	public void testSearchTrue() {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        ListNode expected = new ListNode(2, null, null);
        ListNode actual = l.search(2);
        assertEquals(expected, actual);
	}
	
	@Test(timeout = 5000)
	public void testSizeEmpty() {
		DoublyLinkedList l = new DoublyLinkedList();
        int expected = 0;
        int actual = l.size();
        assertEquals(expected, actual);
	}
	
	@Test(timeout = 5000)
	public void testSize3() {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        int expected = 3;
        int actual = l.size();
        assertEquals(expected, actual);
	}
	
	
	@Test(timeout = 5000)
    public void testAddLast()
    {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        
        int[] list_expected_reversed = {3,2,1};
        ListNode node = l.getTail();
        for (int expected: list_expected_reversed  ) {
        	int actual = node.getData();
        	assertEquals(expected, actual);
        	node = node.getPrevious();
        }       
    }
	
	@Test(timeout = 5000)
    public void testReverse()
    {
		DoublyLinkedList l = new DoublyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        
        l.reverse();
        int[] list_expected_reversed = {3,2,1};
        ListNode node = l.getTail();
        for (Integer expected: list_expected_reversed  ) {
        	Integer actual = node.getData();
        	assertEquals(expected, actual);
        	node = node.getPrevious();
        }       
    }
	
	@Test(timeout = 5000)
	public void testIsOrderedFalseAscendingTrue() 
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = {2,1,3};
		for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = false;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}
	

	@Test(timeout = 5000)
	public void testIsOrderedFalseAscendingFalse() 
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = {2,1,3};
        for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = false;
		boolean ascending = false;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}
	
	@Test(timeout = 5000)
	public void testIsOrderedTrueAscendingFalse() 
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = {3,2,1};
        for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = true;
		boolean ascending = false;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}
	
	@Test(timeout = 5000)
	public void testIsOrderedTrueAscendingTrue() 
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = {1,2, 3};
        for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}
	
	@Test(timeout = 5000)
	public void testIsOrderedEmptyAscendingTrue()
	{
		DoublyLinkedList l = new DoublyLinkedList();
		
		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}
	
	@Test(timeout = 5000)
	public void deleteBeforeEmpty() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = {1};
        for (int i: listBeforeDelete ) {
        	l.addLast(i);
        }
        ListNode nodeDelete = l.search(1);
        assertTrue(nodeDelete != null);
        l.delete(nodeDelete);
        assertTrue(l.isEmpty());

        
	}
	
	@Test(timeout = 5000)
	public void deleteFirstElement() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = {1,2,3};
        for (int i: listBeforeDelete ) {
        	l.addLast(i);
        }
        ListNode nodeDelete = l.search(1);
        int[] listAfterDelete = {3,2};
        l.delete(nodeDelete);
        ListNode node = l.getTail();
        for (int expected: listAfterDelete  ) {
        	int actual = node.getData();
        	assertEquals(expected, actual);
        	node = node.getPrevious();
        }      
	}
	
	@Test(timeout = 5000)
	public void deleteLastElement() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = {1,2,3};
        for (int i: listBeforeDelete ) {
        	l.addLast(i);
        }
        ListNode nodeDelete = l.search(3);
        int[] listAfterDelete = {2,1};
        l.delete(nodeDelete);
        ListNode node = l.getTail();
        for (int expected: listAfterDelete  ) {
        	int actual = node.getData();
        	assertEquals(expected, actual);
        	node = node.getPrevious();
        }      
	}
	
	@Test(timeout = 5000)
	public void deleteMiddleElement() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = {1,2,3};
        for (int i: listBeforeDelete ) {
        	l.addLast(i);
        }
        ListNode nodeDelete = l.search(2);
        int[] listAfterDelete = {3,1};
        l.delete(nodeDelete);
        ListNode node = l.getTail();
        for (int expected: listAfterDelete  ) {
        	int actual = node.getData();
        	assertEquals(expected, actual);
        	node = node.getPrevious();
        }       
        
	}
	
	@Test(timeout = 5000)
	public void testIsPalindromeTrue()
	{
	 	DoublyLinkedList l = new DoublyLinkedList();
		int[] a = {1, 5, 5, 1};
		for (int i: a) {
        	l.addLast(i);
        }
		boolean result = l.isPalindrome(l);
		Assert.assertTrue(result);
	}
	
	@Test(timeout = 5000)
	public void testIsPalindromeFalse()
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] a = {1, 5, 4, 1};
		for (int i: a) {
        	l.addLast(i);
        }
		boolean result = l.isPalindrome(l);
		Assert.assertTrue(!result);
	}
	
	@Test(timeout = 5000)
	public void testIsPalindromeUnit()
	{
		DoublyLinkedList l = new DoublyLinkedList();
		int[] a = {1};
		for (int i: a) {
        	l.addLast(i);
        }
		boolean result = l.isPalindrome(l);
		Assert.assertTrue(result);
	}
}
