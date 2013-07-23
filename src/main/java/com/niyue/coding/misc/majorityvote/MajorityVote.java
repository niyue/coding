package com.niyue.coding.misc.majorityvote;

/*
 * http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
 * How to find if a number is present equal to or more than n/2 times in an array of size n?
 */
public class MajorityVote {
	public Integer find(int[] numbers) {
		Integer majority = null;
		int count = 0;
				
		for(int i = 0; i < numbers.length; i++) {
			if(count == 0) {
				majority = numbers[i];
				count = 1;
			} else {
				if(majority == numbers[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
		
		count = 0;
		for(int i = 0; i < numbers.length; i++) {
			if(majority == numbers[i]) {
				count++;
			}
		}
		if(count < (numbers.length + 1) / 2) {
			majority = null;
		}
		return majority;
	}
}
