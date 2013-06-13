package com.niyue.coding.careercup.sorting;

public class CountingSort {
	public int[] sort(int[] numbers, int min, int max) {
		int[] count = new int[max - min + 1];
		for(int n : numbers) {
			count[n - min]++;
		}
		int j = numbers.length - 1;
		for(int i = count.length - 1; i >= 0; i--) {
			while(count[i] > 0) {
				numbers[j] = i + min;
				count[i]--;
				j--;
			}
		}
		return numbers;
	}
}
