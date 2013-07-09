package com.niyue.coding.careercup.sum15;

import java.util.ArrayList;
import java.util.List;

// http://www.careercup.com/question?id=250694
// consider all permutations as a binary number
public class Sum15 {
	
	public int find(int[] numbers) {
		assert numbers.length == 5;
		int count = 0;
		for(int i = 0; i < 32; i++) {
			List<Integer> nums = mask(numbers, i);
			if(sum(nums) == 15) {
				count++;
			}
		}
		return count;
	}
	
	private List<Integer> mask(int[] numbers, int i) {
		List<Integer> nums = new ArrayList<Integer>();
		
		char[] chars = Integer.toBinaryString(i).toCharArray();
		for(int j = 0; j < 5 && j < chars.length; j++) {
			if(chars[j] == '1') {
				nums.add(numbers[j]);
			}
		}
		return nums;
	}
	
	private int sum(List<Integer> numbers) {
		int sum = 0;
		for(int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
		}
		return sum;
	}
}
