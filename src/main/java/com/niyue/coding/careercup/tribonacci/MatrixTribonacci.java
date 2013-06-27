package com.niyue.coding.careercup.tribonacci;

// http://www.careercup.com/question?id=15072768
// An O(lgn) solution using matrix exponentiation squaring
// http://nayuki.eigenstate.org/page/fast-fibonacci-algorithms
public class MatrixTribonacci {
	private static final int[][] L = new int[][] {{1, 1, 2}};
	private static final int[][] M = new int[][] {
		{0, 0, 1},
		{1, 0, 1},
		{0, 1, 1}
	};
	
	public long get(int n) {
		long result = 0;
		if(n <= 2) {
			result = L[0][n];
		} else {
			int[][] exp = exp(M, n - 2);
			int[][] m = multiply(L, exp);
			result = m[0][2];
		}
		return result;
	}
	
	private int[][] exp(int[][] M, int e) {
		int[][] exp = null;
		if(e == 1) {
			exp = M;
		} else {
			if(e % 2 == 0) {
				M = multiply(M, M);
				exp = exp(M, e / 2);
			} else {
				exp = exp(M, e - 1);
				exp = multiply(M, exp);
			}
		}
		return exp;
	}
	
	private int[][] multiply(int[][] A, int[][] B) {
		int[][] product = new int[A.length][B[0].length];
		for(int y = 0; y < product.length; y++) {
			for(int x = 0; x < product[y].length; x++) {
				int sum = 0;
				for(int i = 0; i < A[0].length; i++) {
					sum += A[y][i] * B[i][x];
				}
				product[y][x] = sum;
			}
		}
		return product;
	}
}
