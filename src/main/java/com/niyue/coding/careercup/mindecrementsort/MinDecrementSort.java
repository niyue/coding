package com.niyue.coding.careercup.mindecrementsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// http://www.careercup.com/question?id=373367
// http://stackoverflow.com/questions/8928061/convert-array-to-a-sorted-one-using-only-two-operations
// TODO: could be turned to a top down O(n^2) DP solution using memoization
public class MinDecrementSort {
	private int[] numbers;
	public int minCost(int[] numbers) {
		this.numbers = numbers;
		int minCost = minCost(0, 0);
		return minCost;
	}
	
	private int minCost(int start, int min) {
		int cost = 0;
		if(start < numbers.length) {
			if(numbers[start] >= min) {
				List<Integer> costs = new ArrayList<Integer>();
				// according to the stackoverflow answer, a value can only be decreased to values in the array
				for(int i = 0; i < numbers.length; i++) {
					if(numbers[i] >= min && numbers[i] <= numbers[start]) {
						int c = minCost(start + 1, numbers[i]) + numbers[start] - numbers[i];
						costs.add(c);
					}
				}
				cost = Collections.min(costs);
			} else {
				cost = minCost(start + 1, min) + numbers[start];
			}
		}
		return cost;
	}
}
