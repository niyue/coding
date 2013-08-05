package com.niyue.coding.misc.balancedpartition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * http://people.csail.mit.edu/bdean/6.046/dp/
 * http://www.careercup.com/question?id=8872057
 * You have a set of n integers each in the range 0 ... K. 
 * Partition these integers into two subsets such that you minimize |S1 - S2|, 
 * where S1 and S2 denote the sums of the elements in each of the two subsets.
 * A O(N^2 * K) solution
 */
public class BalancedPartition {
	public List<Integer> partition(List<Integer> numbers) {
		int K = Collections.max(numbers);
		int N = numbers.size();
		boolean[][] sums = new boolean[N][N * K + 1];
		sums[0][0] = true;
		sums[0][numbers.get(0)] = true;
		for(int i = 1; i < N; i++) {
			for(int s = 0; s <= N * K; s++) {
				sums[i][s] = 
						sums[i - 1][s] || 
						(s - numbers.get(i) >= 0 && sums[i - 1][s - numbers.get(i)]);
			}
		}
		int sum = sum(numbers);
		int closestSum = findClosestSum(sums, N, K, sum);
		List<Integer> partition = findPartition(sums, closestSum, numbers);
		return partition;
	}
	
	private int findClosestSum(boolean[][] sums, int N, int K, int sum) {
		int diff = Integer.MAX_VALUE;
		int closestSum = 0;
		for(int s = 0; s <= N * K; s++) {
			if(sums[N - 1][s]) {
				int currentDiff = Math.abs(sum - 2 * s);
				if(currentDiff < diff) {
					closestSum = s;
					diff = currentDiff;
				}
			}
		}
		return closestSum;
	}
	
	private List<Integer> findPartition(boolean[][] sums, int closestSum, List<Integer> numbers) {
		List<Integer> partition = new ArrayList<Integer>();
		int i = numbers.size() - 1;
		int s = closestSum;
		while(i > 0) {
			if(!sums[i - 1][s]) {
				s -= numbers.get(i);
				partition.add(i);
			}
			i--;
		}
		if(s != 0) {
			partition.add(0);
		}
		Collections.reverse(partition);
		return partition;
	}
	
	private int sum(List<Integer> numbers) {
		int sum = 0;
		for(int n : numbers) {
			sum += n;
		}
		return sum;
	}
	
}
