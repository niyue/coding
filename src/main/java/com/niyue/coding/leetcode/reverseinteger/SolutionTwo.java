package com.niyue.coding.leetcode.reverseinteger;

// http://oj.leetcode.com/problems/reverse-integer/
public class SolutionTwo {
    public int reverse(int x) {
        int r = 0;
        for(int n = Math.abs(x); n > 0; n /= 10) {
        	r = r * 10 + n % 10;
        }
        return x > 0 ? r : -r;
    }
}
