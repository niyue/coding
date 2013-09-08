package com.niyue.coding.careercup.perfectsquarenumber;

import java.util.ArrayList;
import java.util.List;

/*
 * http://www.careercup.com/question?id=7736681
 * How to find a number of 10 digits (non repeated digits) which is a perfect square? perfect square examples: 9 (3x3) 16 (4x4) 25(5x) etc. 
 * Ten digit number example 1,234,567,890
 * Instead of check all possible ten-digit number is a perfect square or not, we check if the all square root's square will lead to a ten-digit number without repetition
 */
public class PerfectSquareNumber {
	public List<Long> find() {
		int low = (int) Math.sqrt(1023456789);
		int high = (int) Math.ceil(Math.sqrt(9876543210L));
		List<Long> numbers = new ArrayList<Long>();
		// long should be declared for i, otherwise i * i will overflow
		for(long i = low; i <= high; i++) {
			long square = i * i;
			if(nonRepeated(square)) {
				numbers.add(square);
			}
		}
		return numbers;
	}
	
	private boolean nonRepeated(long n) {
		boolean[] digits = new boolean[10];
		for(int i = 0; i < 10; i++) {
			int d = (int) (n % 10);
			if(digits[d]) {
				return false;
			} else {
				digits[d] = true;
				n /= 10;
			}
		}
		return true;
	}
}
