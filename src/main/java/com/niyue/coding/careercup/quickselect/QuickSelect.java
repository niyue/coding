package com.niyue.coding.careercup.quickselect;

import java.util.Random;

// http://www.careercup.com/question?id=4356905
// http://en.wikipedia.org/wiki/Selection_algorithm
public class QuickSelect {
	private Random rand = new Random();
	
	public int select(int[] numbers, int k) {
		int kth = quickSelect(numbers, k, 0, numbers.length - 1);
		return kth;
	}
	
	private int quickSelect(int[] numbers, int k, int start, int end) {
		int kth = -1;
		if(start <= end) {
			int pivot = choosePivot(numbers, start, end);
			int pivotPosition = partition(numbers, start, end, pivot);
			if(pivotPosition - start == k) {
				kth = numbers[pivotPosition];
			} else if(pivotPosition - start < k) {
				kth = quickSelect(numbers, k - pivotPosition - 1, pivotPosition + 1, end);
			} else {
				kth = quickSelect(numbers, k, start, pivotPosition - 1);
			}
		}
		return kth;
	}
	
	private int choosePivot(int[] numbers, int start, int end) {
		return rand.nextInt(end - start + 1) + start;
	}
	
	private int partition(int[] numbers, int start, int end, int pivot) {
		int pivotValue = numbers[pivot];
		swap(numbers, pivot, end);
		int j = end - 1;
		int i = start;
		while(i <= j) {
			if(numbers[i] > pivotValue) {
				swap(numbers, i, j);
				j--;
			} else {
				i++;
			}
		}
		swap(numbers, i, end);
		return i;
	}
	
	private void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
