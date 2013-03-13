package com.niyue.coding.leetcode.climbingstairs;

//http://leetcode.com/onlinejudge#question_70
// implement computing nth number in fibonacci sequence
public class Solution {
	public int climbStairs(int n) {
		int one = 1;
		int two = 1;
		int count = 0;
		if (n < 2) {
			count = 1;
		} else {
			while (n > 1) {
				count = one + two;
				one = two;
				two = count;
				n--;
			}
			count = two;
		}
		return count;
	}
}
