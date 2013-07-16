package com.niyue.coding.misc.minlargernumber;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

// http://www.mitbbs.com/article_t/JobHunting/32324613.html

public class MinLargerNumber {
	public int find(int[] digits, int target) {
		Deque<Integer> result = new ArrayDeque<Integer>();
		List<Integer> targetDigits = targetDigits(target);
		boolean[] visited = new boolean[targetDigits.size()];
		for(int i = 0; i < targetDigits.size() && i >= 0;) {
			int current = i;
			int digit = targetDigits.get(i);
			if(!visited[i]) {
				if(i == targetDigits.size() - 1) {
					Integer d = findLargerDigit(digits, digit);
					if(d == null) {
						i--;
						if(!result.isEmpty()) {
							result.removeFirst();
						}
					} else {
						result.addFirst(d);
						break;
					}
				} else {
					Integer d = findEqualDigit(digits, digit);
					if(d == null) {
						d = findLargerDigit(digits, digit);
						if(d != null) {
							result.addFirst(d);
							i++;
							addSmallestDigit(result, digits[0], targetDigits.size() - result.size());
							break;
						} else {
							i--;
							if(!result.isEmpty()) {
								result.removeFirst();
							}
						}
					} else {
						result.addFirst(d);
						i++;
					}
				}
			} else {
				Integer d = findLargerDigit(digits, digit);
				if(d != null) {
					result.addFirst(d);
					i++;
					addSmallestDigit(result, digits[0], targetDigits.size() - result.size());
					break;
				} else {
					i--;
					if(!result.isEmpty()) {
						result.removeFirst();
					}
				}
			}
			visited[current] = true;
		}
		if(result.isEmpty()) {
			addSmallestDigit(result, digits[0], targetDigits.size() + 1 - result.size());
		}
		int integer = toInteger(result);
		return integer;
	}
	
	private void addSmallestDigit(Deque<Integer> result, int digit, int times) {
		for(int i = 0; i < times; i++) {
			result.addFirst(digit);
		}
	}
	
	private int toInteger(Deque<Integer> result) {
		int integer = 0;
		Iterator<Integer> iter = result.descendingIterator();
		while(iter.hasNext()) {
			integer *= 10;
			integer += iter.next();
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
