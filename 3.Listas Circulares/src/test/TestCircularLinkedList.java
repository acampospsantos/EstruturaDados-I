package com.diegopinheiro.estruturadados1.list03;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;


public class TestCircularLinkedList {
	
	@Test(timeout = 5000)
    public void testEmptyTrue()
    {
        CircularLinkedList l = new CircularLinkedList();
        assertTrue(l.isEmpty());
    }
	
	@Test(timeout = 5000)
    public void testEmptyFalse()
    {
		CircularLinkedList l = new CircularLinkedList();
        l.addFirst(0);
        assertTrue(!l.isEmpty());
    }
	
	@Test(timeout = 5000)
    public void testAddFirst()
    {
		CircularLinkedList l = new CircularLinkedList();
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
    public void testAddLast()
    {
		CircularLinkedList l = new CircularLinkedList();
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
		CircularLinkedList l = new CircularLinkedList();
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
		CircularLinkedList l = new CircularLinkedList();
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
		CircularLinkedList l = new CircularLinkedList();
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
		CircularLinkedList l = new CircularLinkedList();
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
		CircularLinkedList l = new CircularLinkedList();
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
		CircularLinkedList l = new CircularLinkedList();
		
		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}
	
	@Test(timeout = 5000)
	public void deleteBeforeEmpty() {
		CircularLinkedList l = new CircularLinkedList();
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
		CircularLinkedList l = new CircularLinkedList();
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
		CircularLinkedList l = new CircularLinkedList();
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
		CircularLinkedList l = new CircularLinkedList();
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
    public void testEqualsTrue()
    {
        CircularLinkedList l1 = new CircularLinkedList();
        CircularLinkedList l2 = new CircularLinkedList();
        int[] list_elements = {1,2,3};
        for (int i: list_elements ) {
        	l1.addFirst(i);
        	l2.addFirst(i);
        }
        
        boolean isEquals = l1.isEquals(l2);
        Assert.assertTrue(isEquals);
    }
	
	@Test(timeout = 5000)
    public void testEqualsFalse()
    {
		CircularLinkedList l1 = new CircularLinkedList();
        CircularLinkedList l2 = new CircularLinkedList();
        int[] list_elements = {1,2,3};
        for (int i: list_elements ) {
        	l1.addFirst(i);
        	l2.addLast(i);
        }
        
        boolean isEquals = l1.isEquals(l2);
        Assert.assertFalse(isEquals);
    }
	
	@Test(timeout = 5000)
    public void testCopyEmpty()
    {
		CircularLinkedList listOriginal = new CircularLinkedList();
		
        CircularLinkedList listCopy = listOriginal.copy();
        Assert.assertFalse(listOriginal == listCopy);
        Assert.assertTrue(listCopy.isEmpty());
    }
	
	
	@Test(timeout = 5000)
    public void testCopyNotEmpty()
    {
		CircularLinkedList listOriginal = new CircularLinkedList();
		int[] list_elements = {1,2,3};
        for (int i: list_elements ) {
        	listOriginal.addLast(i);
        }
        CircularLinkedList listCopy = listOriginal.copy();
        Assert.assertTrue(listOriginal != listCopy);
        ListNode node = listOriginal.getHead();
        for (int expected: list_elements ) {
        	int actual = node.getData();
        	assertEquals(expected, actual);
        	node = node.getNext();
        }      
    }
	
	@Test(timeout = 5000)
    public void testGetEmpty()
    {
		CircularLinkedList listOriginal = new CircularLinkedList();
		
		try {
			listOriginal.get(0);
			Assert.fail("List is empty");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
        
    }
	
	@Test(timeout = 5000)
    public void testGetNotEmpty()
    {
		CircularLinkedList listOriginal = new CircularLinkedList();
		int[] list_elements = {1,2,3};
        for (int i: list_elements ) {
        	listOriginal.addLast(i);
        }
        
        try {
            Assert.assertEquals(1, listOriginal.get(0));
            Assert.assertEquals(2, listOriginal.get(1));
            Assert.assertEquals(3, listOriginal.get(2));
            Assert.assertEquals(1, listOriginal.get(3));
            Assert.assertEquals(2, listOriginal.get(4));
            Assert.assertEquals(3, listOriginal.get(5));
            Assert.assertEquals(1, listOriginal.get(6));
            Assert.assertEquals(2, listOriginal.get(7));
            Assert.assertEquals(3, listOriginal.get(8));
		} catch (Exception e) {
			Assert.fail("List not empty");
		}
 
        
    }

}
