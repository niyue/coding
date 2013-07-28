package com.niyue.coding.careercup.mindecrementsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// http://www.careercup.com/question?id=373367
// http://www.careercup.com/question?id=9333968
// http://stackoverflow.com/questions/8928061/convert-array-to-a-sorted-one-using-only-two-operations
// TODO: could be turned to a top down O(n^2) DP solution using memoization
public class MinDecrementSort {
	private int[] numbers;
	public int minCost(int[] numbers) {
		this.numbers = numbers;
		int minCost = minCost(0, 0);
		return minCost;
	}
	
	// minCost denotes the minimum cost for sorting using the allowed operations for numbers[0...current] when all these numbers are smaller than max
	// max should be a number in the numbers array (except its initial value 0)
	// if the current number is larger than the max, we could try to reduce it to any value between max...numbers[current] and pick up the minimum cost one
	// if the current number is smaller than the max, we have to remove it entirely with the cost of numbers[current]
	private int minCost(int current, int max) {
		int cost = 0;
		if(current < numbers.length) {
			if(numbers[current] >= max) {
				List<Integer> costs = new ArrayList<Integer>();
				// according to the stackoverflow answer, a value can only be decreased to values in the array
				for(int i = 0; i < numbers.length; i++) {
					if(numbers[i] >= max && numbers[i] <= numbers[current]) {
						int c = minCost(current + 1, numbers[i]) + numbers[current] - numbers[i];
						costs.add(c);
					}
				}
				cost = Collections.min(costs);
			} else {
				cost = minCost(current + 1, max) + numbers[current];
			}
		}
		return cost;
	}
}
