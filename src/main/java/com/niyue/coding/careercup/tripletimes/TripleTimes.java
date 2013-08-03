package com.niyue.coding.careercup.tripletimes;

/*
 * http://www.careercup.com/question?id=7902674
 * http://stackoverflow.com//questions/5208343/find-a-special-number-in-an-array
 * http://www.quora.com/Algorithms/Given-an-integer-array-such-that-every-element-occurs-3-times-except-one-element-which-occurs-only-once-how-to-find-that-single-element-in-O-1-space-and-O-n-time-complexity
 * http://www.geeksforgeeks.org/find-the-element-that-appears-once/
 * Given an array where every element occurs three times, except one element which occurs only once. 
 * Find the element that occurs once. 
 * Expected time complexity is O(n) and O(1) extra space.
 */
public class TripleTimes {
	public int find(int[] numbers) {
		// one is used to store all bits that appear once
		// two is used to store all bits that appear twice
		int one = 0, two = 0;
		for(int n : numbers) {
			// a bit appears once (it is set in 'one') and appears in 'n', which means this bit appear twice since n
			two |= one & n;
			one ^= n;
			// a bit appears in both one and two, which means it appears three times since n, we need to remove these bits from both one and two
			int three = one & two;
			one &= ~three;
			two &= ~three;
		}
		return one;
	}
}
