package com.niyue.coding.careercup.triplestack;

/**
 * How can you efficiently implement three stacks in a single array
 * such that no stack overflows until there is no space left in the entire array space.
 * http://www.careercup.com/question?id=15024669
 * Basically, use a structure (the Node class below) containing both the value and next (may be free node or stack node) to manage the stack and free nodes
 * free nodes are linked together by the 'next', and each stack has its stack nodes linked together by 'next' too,
 * and use an nodesInStack to track if the stack is full
 */
public class TripleStack<T> {
	private static final int STACK_NO = 3;
	private int stackSize;
	private Node<T>[] nodes;
	private Integer[] tops = new Integer[STACK_NO];
	private int nodesInStack = 0;
	private int free = 0;
	
	
	@SuppressWarnings("unchecked")
	public TripleStack(int size) {
		stackSize = size;
		nodes = new Node[stackSize];
		for(int i = 0; i < stackSize; i++) {
			nodes[i] = new Node<T>(null, i + 1);
		}
	}
	
	public void push(int i, T value) {
		if(!isFull()) {
			Integer prevTop = tops[i];
			tops[i] = free;
			
			Node<T> freeNode = nodes[free];
			free = freeNode.next;
			
			freeNode.value = value;
			freeNode.next = prevTop;
			
			nodesInStack++;
		} else {
			throw new IllegalStateException("Stack is full");
		}
	}
	
	private boolean isFull() {
		return nodesInStack == stackSize;
	}
	
	public T pop(int i) {
		if(tops[i] != null) {
			int prevTop = tops[i];

			Node<T> poppedNode = nodes[prevTop];
			tops[i] = poppedNode.next;
			T value = poppedNode.value;
			poppedNode.value = null;
			poppedNode.next = free;
			free = prevTop;
			
			nodesInStack--;
			return value;
		} else {
			throw new IllegalStateException("Stack is empty");
		}
	}
	
	private static class Node<T> {
		public T value;
		public Integer next;
		public Node(T value, Integer next) {
			this.value = value;
			this.next = next;
		}
		@Override
		public String toString() {
			return String.format("[%s] => %s", value, next);
		}
	}
}
