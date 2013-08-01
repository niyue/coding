package com.niyue.coding.misc.minmaxqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/*
 *  Design a queue, which has four operations:
 *  1) push, enqueue an element
 *  2) pop, dequeue an element
 *  3) getMin, get the minimum element from the queue
 *  4) getMax, get the maximum element from the queue
 *  All operations can be implemented with amortized O(1) time complexity
 */ 
public class MinMaxQueue<T extends Comparable<T>> {
	private Deque<T> queue = new ArrayDeque<T>();
	private Deque<T> minQueue = new ArrayDeque<T>();
	private Deque<T> maxQueue = new ArrayDeque<T>();
	
	public void push(T e) {
		queue.offerLast(e);
		while(!minQueue.isEmpty() && minQueue.peekLast().compareTo(e) > 0) {
			minQueue.pollLast();
		}
		minQueue.offerLast(e);
		while(!maxQueue.isEmpty() && maxQueue.peekLast().compareTo(e) < 0) {
			maxQueue.pollLast();
		}
		maxQueue.offerLast(e);
	}
	
	public T pop() {
		if(!queue.isEmpty()) {
			T e = queue.pollFirst();
			if(minQueue.peekFirst().compareTo(e) == 0) {
				minQueue.pollFirst();
			}
			if(maxQueue.peekFirst().compareTo(e) == 0) {
				maxQueue.pollFirst();
			}
			return e;
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public T getMin() {
		if(!minQueue.isEmpty()) {
			return minQueue.peekFirst();
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public T getMax() {
		if(!maxQueue.isEmpty()) {
			return maxQueue.peekFirst();
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public int size() {
		return queue.size();
	}
}
