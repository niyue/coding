package com.niyue.coding.careercup.bsttwosum;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class BstTwoSum {
	public List<List<Integer>> twoSum(TreeSet<Integer> bst, int target) {
		Iterator<Integer> head = bst.iterator();
		Iterator<Integer> tail = new ReverseInorderIterator<Integer>(bst);
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(head.hasNext() && tail.hasNext()) {
			Integer headValue = head.next();
			Integer tailValue = tail.next();
			while(headValue < tailValue) {
				if(headValue + tailValue == target) {
					result.add(Arrays.asList(headValue, tailValue));
					if(head.hasNext() && tail.hasNext()) {
						headValue = head.next();
						tailValue = tail.next();
					} else {
						break;
					}
				} else if(headValue + tailValue < target && head.hasNext()) {
					headValue = head.next();
				} else if(headValue + tailValue > target && tail.hasNext()) {
					tailValue = tail.next();
				} else {
					break;
				}
			}
		}
		return result;
	}
	
	// TODO: check out TreeSet.Iterator for comparison
	private static class ReverseInorderIterator<T> implements Iterator<T> {
		private TreeSet<T> bst;
		private Deque<T> stack = new LinkedList<T>();
		private int current = 0;
		
		public ReverseInorderIterator(TreeSet<T> bst) {
			this.bst = bst;
		}

		@Override
		public boolean hasNext() {
			return current < bst.size();
		}

		@Override
		public T next() {
			
			current++;
			return null;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
