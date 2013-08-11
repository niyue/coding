package com.niyue.coding.misc.swapmaxpermutation;

/*
 * Given an integer array and an integer called swapTimes
 * and each element in the array contains a single digit number (0~9), the array stands for a multi-digit number (the lowest index contains the lowest digit in the number).
 * You can swap any two adjacent elements in the array for at most swapTimes 
 * Find the maximum multi-digit number (a permutation of the array) that can be swapped in swapTimes
 * For example, 
 * Input:  array = [1, 2, 3], swapTimes = 2
 * Output: maxPermutation = [3, 1, 2]
 * A naive implementation using greedy algorithm, O(n^2) where n is the length of the digits array
 * always find the maximum digits available allowed by swapTimes and swap the max one with current digit
 *
 */
public class SwapMaxPermutation {
	public int[] find(int[] digits, int swapTimes) {
		swap(digits, 0, swapTimes);
		return digits;
	}
	
	private void swap(int[] digits, int start, int swapTimes) {
		if(swapTimes > 0 && start < digits.length) {
			int maxIndex = max(digits, start, swapTimes);
			if(digits[start] != digits[maxIndex]) {
				swapDigits(digits, start, maxIndex);
			}
			swap(digits, start + 1, swapTimes - (maxIndex - start));
		}
	}
	
	private int max(int[] digits, int start, int swapTimes) {
		int max = Integer.MIN_VALUE;
		int maxIndex = start;
		for(int i = start; i <= start + swapTimes && i < digits.length; i++) {
			if(digits[i] > max) {
				max = digits[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	private void swapDigits(int[] digits, int i, int j) {
		int max = digits[j];
		System.arraycopy(digits, i, digits, i + 1, j - i);
		digits[i] = max;
	}
}
