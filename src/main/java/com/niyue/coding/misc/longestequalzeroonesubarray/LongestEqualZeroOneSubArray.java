package com.niyue.coding.misc.longestequalzeroonesubarray;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array, containing only 0 and 1 in it, find out the longest subarray containing equal number of 0 and 1
 * An O(n) time, O(n) space solution
 */
public class LongestEqualZeroOneSubArray {
	public int[] find(int[] numbers) {
		int[] sums = sums(numbers);
		Map<Integer, Integer> minIndex = minIndex(sums);
		Map<Integer, Integer> maxIndex = maxIndex(sums);
		
		int start = -1;
		int end = -2;
		for(int count : minIndex.keySet()) {
			int min = minIndex.get(count);
			int max = maxIndex.get(count);
			if(max - (min + 1) > end - start) {
				start = min + 1;
				end = max;
			}
		}
		return new int[] {start - 1, end - 1};
	}
	
	// store the cumulative sum difference between the number of 1 and the number of 0
	// sums[i] stands for (the number of 1 - the number of 0) in numbers[0...i]
	// if sums[x] == sums[y], then numbers[x+1...y] contains the equal amount of 0 and 1 in it
	private int[] sums(int[] numbers) {
		int[] sums = new int[numbers.length + 1];
		sums[0] = 0;
		for(int i = 0; i < numbers.length; i++) {
			sums[i + 1] = sums[i] + (numbers[i] == 1 ? 1 : -1);
		}
		return sums;
	}
	
	private Map<Integer, Integer> minIndex(int[] sums) {
		Map<Integer, Integer> minIndex = new HashMap<Integer, Integer>();
		for(int i = 0; i < sums.length; i++) {
			int count = sums[i];
			if(!minIndex.containsKey(count)) {
				minIndex.put(count, i);
			}
		}
		return minIndex;
	}
	
	private Map<Integer, Integer> maxIndex(int[] sums) {
		Map<Integer, Integer> maxIndex = new HashMap<Integer, Integer>();
		for(int i = sums.length - 1; i >= 0; i--) {
			int count = sums[i];
			if(!maxIndex.containsKey(count)) {
				maxIndex.put(count, i);
			}
		}
		return maxIndex;
	}
}
