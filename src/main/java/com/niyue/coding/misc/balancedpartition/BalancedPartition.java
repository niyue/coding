package com.niyue.coding.misc.balancedpartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * http://people.csail.mit.edu/bdean/6.046/dp/
 * You have a set of n integers each in the range 0 ... K. 
 * Partition these integers into two subsets such that you minimize |S1 - S2|, 
 * where S1 and S2 denote the sums of the elements in each of the two subsets.
 * A naive O(2^N) solution
 */
public class BalancedPartition {
	public int partition(List<Integer> numbers) {
		@SuppressWarnings("unchecked")
		List<Integer>[] sums = new List[numbers.size()];
		sums[0] = Arrays.asList(0, numbers.get(0));
		for(int i = 1; i < numbers.size(); i++) {
			List<Integer> previousSums = sums[i - 1];
			List<Integer> ithSums = new ArrayList<Integer>();
			ithSums.addAll(previousSums);
			for(int sum : previousSums) {
				ithSums.add(sum + numbers.get(i));
			}
			sums[i] = ithSums;
		}
		int closestSum = closestSum(sums, numbers);
		return closestSum;
	}
	
	private int sum(List<Integer> numbers) {
		int sum = 0;
		for(int n : numbers) {
			sum += n;
		}
		return sum;
	}
	
	private int closestSum(List<Integer>[] sums, List<Integer> numbers) {
		int sum = sum(numbers);
		int halfSum = sum / 2;
		List<Integer> lastSums = sums[numbers.size() - 1];
		int closest = Integer.MAX_VALUE;
		int closestSum = Integer.MAX_VALUE;
		for(int s : lastSums) {
			if(Math.abs(s - halfSum) < closest) {
				closest = Math.abs(s - halfSum);
				closestSum = halfSum;
			}
		}
		return closestSum;
	}
}
