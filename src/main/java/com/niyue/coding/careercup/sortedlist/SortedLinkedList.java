package com.niyue.coding.careercup.sortedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * Insert a node into a circular linked list.
 * This CLL is sorted. So, if the CLL is like 1->2->4->6->1,
 * you will be asked to input a node 3 and it must come between 2 and 4.
 * This implementation supports to do this in O(n^0.5) (amortized) time complexity and O(n^0.5) space complexity
 */
public class SortedLinkedList {
	private int length;
	
	private Node head;
	
	private List<Node> sections = new LinkedList<Node>();
	
	private int lastUpdate = 0;
	
	public int length() {
		return length;
	}

	public void insert(int value) {
		if(head == null) {
			head = new Node(value);
			head.next = head;
			sections.add(head);
		} else {
			Node insertionNode = findInsertionNode(value);
			Node insertedNode = new Node(value);
			// insert before head
			if(insertionNode == null) {
				insertedNode.next = head;
				Node tailNode = tailNode();
				tailNode.next = insertedNode;
				head = insertedNode;
			} else {
				insertedNode.next = insertionNode.next;
				insertionNode.next = insertedNode;
			}
		}
		length++;
		updateSections();
	}
	
	// returning null means the insertion position is before head
	private Node findInsertionNode(int value) {
		Node insertionNode = null;
		for(Node section : sections) {
			if(section.value <= value) {
				insertionNode = section;
			} else {
				break;
			}
		}
		if(insertionNode != null) {
			while(true) {
				// a node's value is smaller than inserted value and its next value is larger than inserted value
				// or the insertion happens in the tail (its next node is the head node)
				if(insertionNode.value <= value && (insertionNode.next.value >= value || insertionNode.next == head)) {
					break;
				} else {
					insertionNode = insertionNode.next;
				}
			}
		}
		return insertionNode;
	}
	
	private Node tailNode() {
		Node tailNode = lastSection();
		while(tailNode.next != head) {
			tailNode = tailNode.next;
		}
		return tailNode;
	}
	
	// update sections after every n^0.5 times of insertions, so that the amortized performance is O(n^0.5)
	private void updateSections() {
		int sqrt = (int) Math.floor(Math.sqrt(length));
		if(length > lastUpdate + sqrt) {
			sections = new LinkedList<Node>();
			Node cursor = head;
			int i = 0;
			do {
				if(i % sqrt == 0) {
					sections.add(cursor);
				}
				i++;
				cursor = cursor.next;
			} while(cursor.next != head);
			lastUpdate = length;
		}
	}
	
	private Node lastSection() {
		Node lastSection = null;
		for(Node section : sections) {
			lastSection = section;
		}
		return lastSection;
	}
	
	public Node head() {
		return head;
	}
	
	public static class Node {
		public int value;
		public Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return String.format("%s", value);
		}
	}

	@Override
	public String toString() {
		StringBuffer list = new StringBuffer("[");
		Node cursor = head;
		while(true) {
			list.append(cursor.value);
			cursor = cursor.next;
			if(cursor != head) {
				list.append(" ");
			} else {
				break;
			}
		}
		list.append("]");
		return list.toString();
	}
}
