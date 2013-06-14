package com.niyue.coding.careercup.sorting;

public class CountingSort {
	public int[] sort(int[] numbers, int min, int max) {
		int[] count = new int[max - min + 1];
		for(int n : numbers) {
			count[n - min]++;
		}
		int sum = 0;
		for(int i = min; i <= max; i++) {
			sum += count[i - min];
			count[i - min] = sum;
		}
		int[] sortedNumbers = new int[numbers.length];
		for(int i = numbers.length - 1; i >= 0; i--) {
			int sortedIndex = count[numbers[i] - min] - 1;
			sortedNumbers[sortedIndex] = numbers[i];
			count[numbers[i] - min]--;
		}
		return sortedNumbers;
	}
}
