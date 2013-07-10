package com.niyue.coding.misc.arrayshuffle;

// http://www.mitbbs.com/article_t/JobHunting/32152557.html
// O(nlgn) solution to interleave the first half and second half of elements in an array
// a1 a2 a3 a4 a5 b1 b2 b3 b4 b5
// a1 a2 (a3 a4 a5 b1 b2 b3) b4 b5 		# cyclic shift 6 elements 3 positions in the middle because the leading two elements and the last elements are guaranteed in their final half partition and they don't need to be moved
// a1 a2 (b1 b2 b3 a3 a4 a5) b4 b5 		# since each half has five elements and is odd and the middle two elements needs to be swapped so that each of them will be their final half partition
// (a1 a2 b1 b2) a3 b3 (a4 a5 b4 b5) 	# recursively solve the first and second halves 

// NOTE: O(n^2) solution can be implemented with cyclic shift more easily
// a1 (a2 a3 b1 b2 b3) 		# cyclic shift the last 5 elements 2 positions
// => a1 b1 (b2 b3 a2 a3) 	# cyclic shift the last 4 elements 2 positions 
// => a1 b1 a2 (a3 b2 b3) 	# cyclic shift the last 3 elements 1 positions
// => a1 b1 a2 b2 (a3 b3)	# it is done when there are only two elements remained

// This problem could be solved in O(n) according to http://arxiv.org/abs/0805.1598
public class ArrayShuffle {
	public int[] shuffle(int[] numbers) {
		shuffle(numbers, 0, numbers.length);
		return numbers;
	}

	private void shuffle(int[] a, int start, int n) {
		assert a.length % 2 == 0 && a.length >= 2;
		if (n > 2) {
			int k = n / 2;
			int x = n % 4 == 0 ? 0 : 1;
			cyclicShift(a, start + k / 2, k + x);
			if (k % 2 != 0) {
				swap(a, start + k - 1, start + k);
				shuffle(a, start, k - 1);
				shuffle(a, start + k + 1, k - 1);
				return;
			} else {
				shuffle(a, start, k);
				shuffle(a, start + k, k);
			}
		} 
	}

	// NOTE: cyclic shift without using extra space
	private void cyclicShift(int a[], int start, int n) {
		reverse(a, start, start + n - 1);
		reverse(a, start, start + n / 2 - 1);
		reverse(a, start + n / 2, start + n - 1);
	}

	private void reverse(int[] a, int start, int end) {
		while (start < end) {
			swap(a, start, end);
			start++;
			--end;
		}
	}
	
	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
