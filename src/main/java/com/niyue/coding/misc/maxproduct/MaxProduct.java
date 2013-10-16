package com.niyue.coding.misc.maxproduct;

/*
 * Given a positive integer, it can be splited into the sum of two numbers, A and B
 * if n = A + B, define f(n) = A * B + f(A) + f(B)
 * Find the maximum value for f(n) for a given n 
 */
public class MaxProduct {
	public int maxProduct(int n) {
		assert n > 0;
		int[] maxes = new int[n + 1];
		maxes[1] = 0;
		
		for(int i = 2; i <= n; i++) {
			for(int a = 1; a <= i / 2; a++) {
				int product = (a * (i - a)) + maxes[a] + maxes[i - a];
				if(product > maxes[i]) {
					maxes[i] = product;
				}
			}
		}
		
		return maxes[n];
	}
}
