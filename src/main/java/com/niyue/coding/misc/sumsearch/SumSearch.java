package com.niyue.coding.misc.sumsearch;

/*
 * Given a sorted array of unsigned integers, given an integer sum b,
 * find an integer k, when changing every number larger than k to k in the array, the sum of the array becomes b.
 * For example, given array [1, 2, 5, 7, 7, 8], b = 26, then k should be 6 because sum([1, 2, 5, 6, 6, 6]) = 26
 * 1) Calculate all cumulative sum for the array
 * 2) Do binary search using the criteria: 
 * use a guess k = (b - sums[mid]) / (length - mid)
 * midSum = sums[mid] + (length - mid) * k
 * binary search if midSum is equal to b
 */
public class SumSearch {
	public int search(int[] numbers, int b) {
		int[] sums = sums(numbers);
		int k = binarySearch(numbers, sums, b);
		return k;
	}
	
	private int binarySearch(int[] numbers, int[] sums, int b) {
		int start = 0;
		int end = numbers.length - 1;
		int k = -1;
		int mid = -1;
		int midSum = -1;
		while(start <= end) {
			mid = start + (end - start) / 2;
			int numbersGreaterThanK = numbers.length - (mid + 1);
			k = numbersGreaterThanK == 0 
					? numbers[end] 
					: (b - sums[mid]) / numbersGreaterThanK;
			midSum = sums[mid] + numbersGreaterThanK * k;
			if(midSum == b) {
				break;
			} else if(midSum < b) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		if(midSum != b || k > numbers[numbers.length - 1]) {
			k = -1;
		}
		return k;
	}
	
	// calculate the cumulative sum array
	// sums[i] stands for the cumulative sum in numbers[0...i]
	private int[] sums(int[] numbers) {
		int[] sums = new int[numbers.length];
		for(int i = 0; i < sums.length; i++) {
			int prevSum = i == 0 ? 0 : sums[i - 1];
			sums[i] = prevSum + numbers[i];
		}
		return sums;
	}
}
