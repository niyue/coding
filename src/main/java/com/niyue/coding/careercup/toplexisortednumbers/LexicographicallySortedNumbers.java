package com.niyue.coding.careercup.toplexisortednumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.careercup.com/question?id=5680043955060736
 * Given a positive integer number N, output a lexicographically sorting for numbers [1, 2, ..., N]. 
 * Namely, numbers are not sorted by their decimal values but by their string comparison order. For example:
 * Input: N = 10
 * Output: [1, 10, 2, 3, 4, 5, 6, 7, 8, 9]
 * Input: N = 11
 * Output: [1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9]
 * Back tracking
 *
 */
public class LexicographicallySortedNumbers {
	public List<Integer> sort(int n) {
		return sort(0, n);
	}
	
	private List<Integer> sort(int start, int top) {
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			int next = start * 10 + i; 
			if (next > 0 && next <= top) {
				nums.add(next);
				nums.addAll(sort(next, top));
			}
		}
		return nums;
	}
}
