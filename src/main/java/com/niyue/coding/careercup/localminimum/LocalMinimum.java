package com.niyue.coding.careercup.localminimum;

// http://www.careercup.com/question?id=8223978
public class LocalMinimum {
	public int search(int[] numbers) {
		assert numbers.length >= 3;
		assert numbers[0] >= numbers[1] && 
				numbers[numbers.length - 2] <= numbers[numbers.length - 1];
		return searchLocalMin(numbers);
	}
	
	private int searchLocalMin(int[] numbers) {
		int start = 0;
		int end = numbers.length - 1;
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(isLocalMinimum(numbers, mid)) {
				return mid;
			} else if(isDecreasing(numbers, mid)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	private boolean isLocalMinimum(int[] numbers, int i) {
		return  i > 0 && 
				i < numbers.length - 1 &&
				numbers[i] <= numbers[i - 1] && 
				numbers[i] <= numbers[i + 1];
	}
	
	private boolean isDecreasing(int[] numbers, int i) {
		return numbers[i - 1] >= numbers[i] && numbers[i] >= numbers[i + 1];
	}
}
