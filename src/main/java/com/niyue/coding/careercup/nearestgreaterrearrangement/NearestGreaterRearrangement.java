package com.niyue.coding.careercup.nearestgreaterrearrangement;

import java.util.ArrayList;
import java.util.List;

// From the set of natural integer numbers 
// Let x = 1234 = {1, 2, 3, 4} 
// Let y = 2410 = {2, 4, 1, 0} 
// Write an algorithm to compute the rearrangement of x that is closest to y but still greater than y. 
// Both x and y have the same number of digits. 
// http://www.careercup.com/question?id=14942777
public class NearestGreaterRearrangement {
	public List<Integer> rearrange(List<Integer> source, List<Integer> target) {
		List<Integer> rearrangement = new ArrayList<Integer>(target.size());
		int[] digits = digits(source);
		boolean[] visited = new boolean[target.size()];
		for(int i = 0; i < target.size();) {
			int digit = target.get(i);
			if(!visited[i]) {
				visited[i] = true;
				if(digits[digit] > 0) {
					rearrangement.add(digit);
					digits[digit]--;
					i++;
				} else {
					Integer biggerDigit = getBiggerDigit(digits, digit);
					if(biggerDigit != null) {
						rearrangement.add(biggerDigit);
						digits[biggerDigit]--;
						addRemainingDigits(rearrangement, digits);
						break;
					} else {
						if(i > 0) {
							i--;
							rearrangement.remove(rearrangement.size() - 1);
							digits[target.get(i)]++;
						}
					}
				}
			} else {
				Integer biggerDigit = getBiggerDigit(digits, digit);
				if(biggerDigit != null) {
					rearrangement.add(biggerDigit);
					digits[biggerDigit]--;
					addRemainingDigits(rearrangement, digits);
					break;
				} else {
					if(i == 0) {
						rearrangement = null;
						break;
					} else {
						i--;
						rearrangement.remove(rearrangement.size() - 1);
						digits[target.get(i)]++;
					}
				}
			}
		}
		return rearrangement;
	}
	
	private void addRemainingDigits(List<Integer> rearrangement, int[] digits) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < digits[i]; j++) {
				rearrangement.add(digits[i]);
			}
		}
	}
	
	private int[] digits(List<Integer> number) {
		int[] digits = new int[10];
		for(int digit : number) {
			digits[digit]++;
		}
		return digits;
	}
	
	private Integer getBiggerDigit(int[] digits, int digit) {
		Integer biggerDigit = null;
		for(int i = digit + 1; i < 10; i++) {
			if(digits[i] > 0) {
				biggerDigit = i;
				break;
			}
		}
		return biggerDigit;
	}
}
