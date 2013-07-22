package com.niyue.coding.misc.minqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*
 * how to design a queue, in addition to insert(), delete(), also has a function which returns the minimum element? 
 * All operations in O(1) time
 */
public class MinQueue<E extends Comparable<E>> {
	private Queue<E> queue = new ArrayDeque<E>();
	private Deque<E> minDeque = new ArrayDeque<E>();
	
	public void offer(E e) {
		queue.offer(e);
		while(!minDeque.isEmpty() && minDeque.peekLast().compareTo(e) > 0) {
			minDeque.pollLast();
		}
		minDeque.offerLast(e);
	}
	
	public E poll() {
		E value = queue.poll();
		if(value.compareTo(minDeque.peekFirst()) == 0) {
			minDeque.pollFirst();
		}
		return value;
	}
	
	public E min() {
		return minDeque.peekFirst();
	}
}
