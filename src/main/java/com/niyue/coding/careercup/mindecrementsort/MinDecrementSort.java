package com.niyue.coding.careercup.mindecrementsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// http://www.careercup.com/question?id=373367
// http://stackoverflow.com/questions/8928061/convert-array-to-a-sorted-one-using-only-two-operations
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
				for(int i = min; i <= numbers[start]; i++) {
					int c = minCost(start + 1, i) + numbers[start] - i;
					costs.add(c);
				}
				cost = Collections.min(costs);
			} else {
				cost = minCost(start + 1, min) + numbers[start];
			}
		}
		return cost;
	}
}
