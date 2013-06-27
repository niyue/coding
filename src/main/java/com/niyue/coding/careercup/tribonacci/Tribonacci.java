package com.niyue.coding.careercup.tribonacci;

// http://www.careercup.com/question?id=15072768
// An O(n) solution to the tribonacci problem
// http://nayuki.eigenstate.org/page/fast-fibonacci-algorithms
public class Tribonacci {
	public long get(int n) {
		long[] prev = new long[] {1, 1, 2};
		long result = 0;
		if(n > 2) {
			for(int i = 3; i <= n; i++) {
				long next = prev[0] + prev[1] + prev[2];
				prev[0] = prev[1];
				prev[1] = prev[2];
				prev[2] = next;
			}
			result = prev[2];
		} else {
			result = prev[n];
		}
		return result;
	}
}
