package com.niyue.coding.leetcode.pow;

// http://leetcode.com/onlinejudge#question_50
public class Solution {
    public double pow(double x, int n) {
    	double product = 1;
    	boolean negativePow = n < 0;
    	n = Math.abs(n);
    	while(n > 0) {
			if(isOdd(n)) {
				product *= x;
				n--;
			} else {
				n /= 2;
				x *= x;
			}        
    	}
    	if(negativePow) {
    		product = 1 / product;
    	}
    	return product;
    }

    private boolean isOdd(int n) {
    	return (n & 1) == 1;
    }
}
