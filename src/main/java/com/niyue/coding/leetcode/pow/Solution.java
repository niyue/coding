package com.niyue.coding.leetcode.pow;

/*
 *  http://leetcode.com/onlinejudge#question_50
 *  http://oj.leetcode.com/problems/powx-n/
 */
public class Solution {
    public double pow(double x, int n) {
    	double pow = 1;
    	boolean negativePow = n < 0;
    	n = Math.abs(n);
    	while(n > 0) {
			if(isOdd(n)) {
				pow *= x;
				n--;
			} else {
				x *= x;
				n /= 2;
			}        
    	}
    	return negativePow ? pow : 1 / pow;
    }

    private boolean isOdd(int n) {
    	return (n & 1) == 1;
    }
}
