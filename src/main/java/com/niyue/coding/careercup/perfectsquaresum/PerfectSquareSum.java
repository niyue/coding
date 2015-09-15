package com.niyue.coding.careercup.perfectsquaresum;


/*
 * 
 * http://www.careercup.com/question?id=5725584103571456
 * Given a number "n", find the least number of perfect square numbers sum needed to get "n" 
 * Example: 
 * n = 12, return 3 (4 + 4 + 4) = (2^2 + 2^2 + 2^2) NOT (3^2 + 1 + 1 + 1) 
 * n = 6,  return 3 (4 + 1 + 1) = (2^2 + 1^2 + 1^2)
 * 
 * Recurrence formula: 
 * f(n) = MIN(each j in 1..sqrt(n) 1 + f(n - j^2))
 * Time complexity: O(n^1.5), space complexity: O(n)
 */
public class PerfectSquareSum {
	public int leastNumberOfPerfectSequares(int n) {
		int[] result = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			result[i] = minForAllPossibleSum(i, result);
		}
		return result[n];
	}
	
	private int minForAllPossibleSum(int n, int[] result) {
		int min = Integer.MAX_VALUE;
		// iterate all perfect square numbers less than n
		for (int j = 1; j <= (int) Math.sqrt(n); j++) {
			int sum = 1 + result[n - j*j];
			if (sum < min) {
				min = sum;
			}
		}
		return min;
	}
}
