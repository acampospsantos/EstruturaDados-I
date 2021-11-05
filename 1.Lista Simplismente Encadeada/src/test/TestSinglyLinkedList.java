package com.diegopinheiro.estruturadados1.list01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.diegopinheiro.estruturadados1.list01.ListNode;
import com.diegopinheiro.estruturadados1.list01.SinglyLinkedList;

import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class TestSinglyLinkedList {
    /**
     * Rigorous Test :-)
     */
	@Test
    public void testEmptyTrue()  
	{
        SinglyLinkedList l = new SinglyLinkedList();
        assertTrue(l.isEmpty());
    }
	
	@Test
    public void testEmptyFalse()   {
		SinglyLinkedList l = new SinglyLinkedList();
        l.addFirst(0);
        assertTrue(!l.isEmpty());
    }
	
	@Test
    public void testAddFirst()  
	{
        SinglyLinkedList l = new SinglyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addFirst(i);
        }
        
        int[] list_expected_reversed = {3,2,1};
        
        ListNode node = l.getHead();
        for (int expected: list_expected_reversed  ) {
        	int actual = node.getData();
        	assertEquals(expected, actual);
        	node = node.getNext();
        }       
    }
	
	@Test
	public void testSearchEmpty()
	{
        SinglyLinkedList l = new SinglyLinkedList();
        ListNode expected = null;
        ListNode actual = l.search(1);
        assertEquals(expected, actual);
	}
	
	
	@Test
	public void testSearchNull() 
	{
        SinglyLinkedList l = new SinglyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        ListNode expected = null;
        ListNode actual = l.search(4);
        assertEquals(expected, actual);
	}
	
	@Test
	public void testSearchTrue()
	{
        SinglyLinkedList l = new SinglyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        ListNode expected = new ListNode(2, null);
        ListNode actual = l.search(2);
        assertEquals(expected, actual);
	}
	
	@Test
	public void testSizeEmpty()
	{
        SinglyLinkedList l = new SinglyLinkedList();
        int expected = 0;
        int actual = l.size();
        assertEquals(expected, actual);
	}
	
	@Test
	public void testSize3() 
	{
        SinglyLinkedList l = new SinglyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        int expected = 3;
        int actual = l.size();
        assertEquals(expected, actual);
	}
	
	
	@Test
    public void testAddLast() 	
	{
        SinglyLinkedList l = new SinglyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addLast(i);
        }
        
        ListNode node = l.getHead();
        for (int expected: list_expected  ) {
        	int actual = node.getData();
        	assertEquals(expected, actual);
        	node = node.getNext();
        }       
    }
	
	@Test
    public void testReverse() 
	{
        SinglyLinkedList l = new SinglyLinkedList();
        int[] list_expected = {1,2,3};
        for (int i: list_expected ) {
        	l.addFirst(i);
        }
        
        l.reverse();
        
        ListNode node = l.getHead();
        for (Integer expected: list_expected  ) {
        	Integer actual = node.getData();
        	assertEquals(expected, actual);
        	node = node.getNext();
        }       
    }
	
	@Test
	public void testIsOrderedFalseAscendingTrue()
	{
		SinglyLinkedList l = new SinglyLinkedList();
		int[] list_ordered_false = {2,1,3};
		for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = false;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}
	

	@Test
	public void testIsOrderedFalseAscendingFalse() 
	{
 		SinglyLinkedList l = new SinglyLinkedList();
		int[] list_ordered_false = {2,1,3};
        for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = false;
		boolean ascending = false;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsOrderedTrueAscendingFalse()
	{
		SinglyLinkedList l = new SinglyLinkedList();
		int[] list_ordered_false = {3,2,1};
        for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = true;
		boolean ascending = false;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsOrderedTrueAscendingTrue() 
	{
		SinglyLinkedList l = new SinglyLinkedList();
		int[] list_ordered_false = {1,2, 3};
        for (int i: list_ordered_false ) {
        	l.addLast(i);
        }
		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsOrderedEmptyAscendingTrue()
	{
		SinglyLinkedList l = new SinglyLinkedList();
		
		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}
	
	@Test
	public void delete() 
	{
		SinglyLinkedList l = new SinglyLinkedList();
		int[] listBeforeDelete = {1,2, 3};
        for (int i: listBeforeDelete ) {
        	l.addLast(i);
        }
        ListNode nodeDelete = l.search(2);
        int[] listAfterDelete = {1,3};
        l.delete(nodeDelete);
        ListNode node = l.getHead();
        for (int expected: listAfterDelete  ) {
        	int actual = node.getData();
        	assertEquals(expected, actual);
        	node = node.getNext();
        }       
        
	}
}
