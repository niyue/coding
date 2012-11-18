package com.niyue.coding.careercup.sortedlist;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SortedLinkedListTest {
	@Test
	public void testInsertOneElement() throws Exception {
		SortedLinkedList list = new SortedLinkedList();
		list.insert(0);
		assertEquals("[0]", list.toString());
	}
	
	@Test
	public void testInsertElementsAscendingly() throws Exception {
		SortedLinkedList list = new SortedLinkedList();
		list.insert(0);
		list.insert(1);
		assertEquals("[0 1]", list.toString());
	}
	
	@Test
	public void testInsertElementsDescendingly() throws Exception {
		SortedLinkedList list = new SortedLinkedList();
		list.insert(1);
		list.insert(0);
		assertEquals("[0 1]", list.toString());
	}
	
	@Test
	public void testInsertThreeElementsAscendingly() throws Exception {
		SortedLinkedList list = new SortedLinkedList();
		list.insert(0);
		list.insert(1);
		list.insert(2);
		assertEquals("[0 1 2]", list.toString());
	}
	
	@Test
	public void testInsertThreeElementsDescendingly() throws Exception {
		SortedLinkedList list = new SortedLinkedList();
		list.insert(2);
		list.insert(1);
		list.insert(0);
		assertEquals("[0 1 2]", list.toString());
	}
	
	@Test
	public void testInsertManyElementsDescendingly() throws Exception {
		SortedLinkedList list = new SortedLinkedList();
		list.insert(9);
		list.insert(8);
		list.insert(7);
		list.insert(6);
		list.insert(5);
		list.insert(4);
		list.insert(3);
		list.insert(2);
		list.insert(1);
		list.insert(0);
		assertEquals("[0 1 2 3 4 5 6 7 8 9]", list.toString());
	}
	
	@Test
	public void testInsertThreeElementsRandomly() throws Exception {
		SortedLinkedList list = new SortedLinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(0);
		assertEquals("[0 1 2]", list.toString());
	}
	
	@Test
	public void testInsertManyElementsRandomly() throws Exception {
		SortedLinkedList list = new SortedLinkedList();
		list.insert(3);
		list.insert(8);
		list.insert(7);
		list.insert(6);
		list.insert(9);
		list.insert(4);
		list.insert(2);
		list.insert(1);
		list.insert(5);
		list.insert(0);
		assertEquals("[0 1 2 3 4 5 6 7 8 9]", list.toString());
	}
}
