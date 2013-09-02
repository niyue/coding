package com.niyue.coding.careercup.versionedstack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/*
 * http://www.careercup.com/question?id=10625661
 * You need to implement a versioned stack, i.e. version of stack will increment after each push/pop. Apart from push/pop, implement a method print(n) which would print stack state corresponding to version 'n'. For example: 
 * -> initially stack is empty. 
 * -> Version 1: 11 is pushed 
 * -> Version 2: 8 is pushed 
 * -> version 3: pop. only 11 left 
 * -> Version 4: 15 is pushed 
 * .... 
 * And so on. 
 * Print(n) should print state at version 'n'. 
 * Here 1 should print 11, 2 should print 8, 11... 
 * All methods should be as efficient as possible.
 */
public class VersionedStack<E> {
	private int version = 0;
	private Map<Integer, StackNode<E>> versionMap = new HashMap<Integer, StackNode<E>>();
	private List<StackNode<E>> versionTree = new ArrayList<StackNode<E>>();
	private StackNode<E> top = null;
	
	public void push(E e) {
		StackNode<E> prevNode = version == 0 ? null : versionMap.get(version);
		version++;
		StackNode<E> node = new StackNode<E>(e, prevNode);
		versionTree.add(node);
		top = node;
		versionMap.put(version, top);
	}
	
	public E pop() {
		if(top == null) {
			throw new NoSuchElementException();
		}
		E v = top.value;
		top = top.prev;
		version++;
		versionMap.put(version, top);
		return v;
	}
	
	public List<E> version(int version) {
		StackNode<E> node = versionMap.get(version);
		List<E> stack = new ArrayList<E>();
		while(node != null) {
			stack.add(node.value);
			node = node.prev;
		}
		return stack;
	}
	
	public int getVersion() {
		return version;
	}
	
	private static class StackNode<E> {
		public final StackNode<E> prev;
		public E value;
		public StackNode(E value, StackNode<E> prev) {
			this.value = value;
			this.prev = prev;
		}
	}
}
