package com.niyue.coding.careercup.dutchflag;

// sort with three way Dutch national flag problem
// http://www.careercup.com/question?id=67700
public class DutchFlag {
	public int[] sort(int[] numbers, int low, int high) {
		int l = 0;
		int h = numbers.length - 1;
		for(int i = 0; i < h;) {
			if(numbers[i] > high) {
				swap(numbers, i, h);
				h--;
			} else if(numbers[i] < low) {
				swap(numbers, i, l);
				l++;
				i++;
			} else {
				i++;
			}
		}
		return numbers;
	}
	
	private void swap(int[] numbers, int x, int y) {
		int temp = numbers[x];
		numbers[x] = numbers[y];
		numbers[y] = temp;
	}
}
