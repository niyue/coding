package com.niyue.coding.misc.minlargernumber;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

// http://www.mitbbs.com/article_t/JobHunting/32324613.html

public class MinLargerNumber {
	public int find(int[] digits, int target) {
		Deque<Integer> result = new ArrayDeque<Integer>();
		List<Integer> targetDigits = targetDigits(target);
		boolean[] visited = new boolean[targetDigits.size()];
		for(int i = 0; i < targetDigits.size();) {
			int current = i;
			int digit = targetDigits.get(i);
			if(visited[i]) {
				Integer d = findLargerDigit(digits, digit);
				if(d != null) {
					result.addFirst(d);
					i++;
					// find smallest digits and break
					result.addAll(Collections.nCopies(digits[0], targetDigits.size() - result.size()));
				} else {
					i--;
					result.removeFirst();
				}
			} else {
				if(i == targetDigits.size() - 1) {
					Integer d = findLargerDigit(digits, digit);
					if(d == null) {
						i--;
						result.removeFirst();
					}
				} else {
					Integer d = findEqualDigit(digits, digit);
					if(d == null) {
						d = findLargerDigit(digits, digit);
						if(d != null) {
							result.addFirst(d);
							i++;
							result.addAll(Collections.nCopies(digits[0], targetDigits.size() - result.size()));
						} else {
							i--;
							result.removeFirst();
						}
					} else {
						result.addFirst(d);
						i++;
					}
				}
			}
			visited[current] = true;
		}
		int integer = toInteger(result);
		return integer;
	}
	
	private int toInteger(Deque<Integer> result) {
		int integer = 0;
		for(int i = 0; i < result.size(); i++) {
			integer *= 10;
			integer += result.removeLast();
		}
		return integer;
	}
	
	private Integer findLargerDigit(int[] digits, int digit) {
		Integer d = null;
		for(int i = 0; i < digits.length; i++) {
			if(digits[i] > digit) {
				d = digits[i];
				break;
			}
		}
		return d;
	}
	
	private Integer findEqualDigit(int[] digits, int digit) {
		Integer d = null;
		for(int i = 0; i < digits.length; i++) {
			if(digits[i] == digit) {
				d = digits[i];
				break;
			}
		}
		return d;
	}
	
	private List<Integer> targetDigits(int target) {
		assert target > 0;
		List<Integer> digits = new ArrayList<Integer>();
		while(target > 0) {
			int lastDigit = target % 10;
			digits.add(lastDigit);
			target /= 10;
		}
		Collections.reverse(digits);
		return digits;
	}
}
