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
 */
public class SubsetSum {
	private boolean[][][] maxSet;
	
	public int[] maxSubSet(int[] A, int S, int m) {
		assert m >= 1 && S >= 0;
		maxSet = new boolean[A.length][m][S + 1];
		for(int i = 0; i < A.length; i++) {
			for(int s = 1; s < S; s++) {
				maxSet[i][0][s] = A[i] == s; 
			}
		}
		
		for(int i = 1; i < A.length; i++) {
			for(int j = 0; j < m; j++) {
				for(int s = 1; s < S; s++) {
					maxSet[i][j][s] = 
							maxSet[i - 1][j][s] || 
							i > 0 && j > 0 && maxSet[i - 1][j - 1][s - A[i]];
				}
			}
		}
		
		int maxSum = 0;
		for(int s = S; s >= 0; s--) {
			if(maxSet[A.length - 1][m - 1][s]) {
				maxSum = s;
				break;
			}
		}
		
		System.out.format("max sum is %d\n", maxSum);
		int[] solution = new int[m];
		int i = A.length - 1;
		for(int j = m - 1; j >= 0;) {
			if(i == 0 && j == 0 && maxSet[0][j][maxSum] || 
			   i > 0 && j > 0 && maxSet[i - 1][j - 1][maxSum - A[i]]) {
				solution[j] = A[i];
				maxSum -= A[i];
				j--;
				i--;
			} else {
				i--;
			}
		}
		return solution;
	}
}
