package com.niyue.coding.misc.maxrollingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// http://www.mitbbs.com/article_t/JobHunting/32156867.html
// Given an integer array of numbers and an integer k, sliding a k length window from the zeroth position of the array
// output each max value in the window
// An O(n) solution using a double ended deque to hold the maximum values in the window
public class MaxRollingDequeWindow {
	public List<Integer> search(List<Integer> numbers, int k) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		for(int i = 0; i < k; i++) {
			slide(deque, numbers.get(i));
		}
		
		List<Integer> maxes = new ArrayList<Integer>(numbers.size() - k);
		maxes.add(deque.peekLast());
		
		for(int i = k; i < numbers.size(); i++) {
			int removed = numbers.get(i - k);
			if(deque.peekLast() == removed) {
				deque.pollLast();
			}
			
			slide(deque, numbers.get(i));
			maxes.add(deque.peekLast());
		}
		return maxes;
	}
	
	private void slide(Deque<Integer> deque, int newNumber) {
		while(!deque.isEmpty() && deque.peekFirst() < newNumber) {
			deque.pollFirst();
		}
		deque.offerFirst(newNumber);
	}
}
