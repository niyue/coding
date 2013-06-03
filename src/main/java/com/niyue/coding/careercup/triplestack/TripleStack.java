package com.niyue.coding.careercup.triplestack;

/**
 * How can you efficiently implement three stacks in a single array
 * such that no stack overflows until there is no space left in the entire array space.
 */
// http://www.careercup.com/question?id=15024669
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
			Node<T> freeNode = nodes[free];
			freeNode.value = value;
			int nextFree = freeNode.next;
			freeNode.next = tops[i];
			tops[i] = free;
			free = nextFree;
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
			Node<T> poppedNode = nodes[tops[i]];
			T value = poppedNode.value;
			poppedNode.value = null;
			free = tops[i];
			tops[i] = poppedNode.next;
			poppedNode.next = free;
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
