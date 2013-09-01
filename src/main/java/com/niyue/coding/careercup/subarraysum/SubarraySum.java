package com.niyue.coding.careercup.subarraysum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * http://www.careercup.com/question?id=13507662
 * Given an array having positive integers, find a continuous subarray which adds to a given number.
 * The following solution can be used to solve non-positive arrays as well
 * Calculate all cumulative sums, and use a hash map to track the sum and their indices
 * For each sum, find if there is sum + target or sum - target exists in the map to determine if such a subarray exist
 * If we need to find all solutions, the moving start/end pointers solution is easier, however, the solution latter can not be applied to array with negative numbers in it
 */
public class SubarraySum {
	public int[] find(int[] numbers, int target) {
		int[] sums = sums(numbers);
		Map<Integer, List<Integer>> sumsMap = sumsMap(sums);
		int[] result = null;
		if(target == 0) {
			for(int i = 0; i < sums.length; i++) {
				if(sumsMap.get(sums[i]).size() >= 2) {
					result = new int[] {sumsMap.get(sums[i]).get(0), sumsMap.get(sums[i]).get(1)};
					break;
				}
			}
		} else if(sumsMap.containsKey(target)) {
			result = new int[] {0, sumsMap.get(target).get(0)};
		} else {
			for(int i = 0; i < sums.length; i++) {
				if(sumsMap.containsKey(sums[i] + target)) {
					result = new int[] {sumsMap.get(sums[i] + target).get(0), i};
					Arrays.sort(result);
					result[0]++; // exclude the first index
					break;
				}
				if(sumsMap.containsKey(sums[i] - target)) {
					result = new int[] {sumsMap.get(sums[i] - target).get(0), i};
					Arrays.sort(result);
					result[0]++;
					break;
				}
			}
		}
		return result;
	}
	
	private int[] sums(int[] numbers) {
		int[] sums = new int[numbers.length];
		int prevSum = 0;
		for(int i = 0; i < numbers.length; i++) {
			sums[i] = prevSum + numbers[i];
			prevSum = sums[i];
		}
		return sums;
	}
	
	private Map<Integer, List<Integer>> sumsMap(int[] sums) {
		Map<Integer, List<Integer>> sumsMap = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < sums.length; i++) {
			if(!sumsMap.containsKey(sums[i])) {
				sumsMap.put(sums[i], new ArrayList<Integer>());
			}
			sumsMap.get(sums[i]).add(i);
		}
		return sumsMap;
	}
	
}
