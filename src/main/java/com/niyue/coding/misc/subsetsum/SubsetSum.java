package com.niyue.coding.misc.subsetsum;

/*
 * Given n non repeating positive integers and another integer S, 
 * find m integers whose sum <= S and their sum is maximum that is possible
 * For example:
 * Input: A = [1, 3, 9, 15], S = 13, m = 2
 * Output: [3, 9]
 * 
 * Input: A = [1, 3, 9, 15], S = 10, m = 2
 * Output: [1, 9]
 * 
 * O(n * m * S) dynamic programming solution, but there are some edge case handling issue for the implementation
 * f(i, j, s) returns a boolean value, denoting in A[0..i], whether there are j numbers whose sum is s.
 * DP recurrence formula:  
 * 		f(i, j, s) = f(i - 1, j, s) || f(i - 1, j - 1, s - A[i]) 
 */
public class SubsetSum {
	private boolean[][][] maxSet;
	
	public int[] maxSubSet(int[] A, int S, int m) {
		assert m >= 1 && S >= 0;
		maxSet = new boolean[A.length][m + 1][S + 1];
		for(int i = 0; i < A.length; i++) {
			maxSet[i][0][0] = true; 
		}
		
		if(S - A[0] >= 0) {
			maxSet[0][1][A[0]] = true;
		}
		
		for(int i = 1; i < A.length; i++) {
			for(int j = 1; j <= i + 1 && j <= m; j++) {
				for(int s = 1; s <= S; s++) {
					maxSet[i][j][s] = 
							maxSet[i - 1][j][s] || 
							s - A[i] >= 0 && maxSet[i - 1][j - 1][s - A[i]];
				}
			}
		}
		
		int maxSum = 0;
		for(int s = S; s >= 0; s--) {
			if(maxSet[A.length - 1][m][s]) {
				maxSum = s;
				break;
			}
		}
		
		int[] solution = getSolution(A, maxSum, m);
		return solution;
	}
	
	private int[] getSolution(int[] A, int S, int m) {
		int[] solution = new int[m];
		for(int j = m, i = A.length - 1; j > 0 && i >= 0 && S > 0; i--) {
			if(i == 0 && S == A[0] ||
			   i > 0 && S - A[i] >= 0 && maxSet[i - 1][j - 1][S - A[i]]) {
				solution[j - 1] = A[i];
				S -= A[i];
				j--;
			}
		}
		return solution;
	}
}
