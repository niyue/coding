package com.niyue.coding.misc.threeincreasingsubsequence;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Given a list of numbers A, find i < j < k satisfying A[i] < A[j] < A[k]
 */
public class ThreeIncreasingSubsequence {
	private static final int NOT_EXIST = -1;

	public List<Integer> find(int[] numbers) {
		int[] lmin = lmin(numbers);
		int[] rmax = rmax(numbers);
		for (int j = 1; j < numbers.length - 1; j++) {
			if (numbers[lmin[j]] < numbers[j] && numbers[j] < numbers[rmax[j]]) {
				return Arrays.asList(lmin[j], j, rmax[j]);
			}
		}
		return Collections.emptyList();
	}

	private int[] lmin(int[] numbers) {
		int[] lmin = new int[numbers.length];
		int min = NOT_EXIST;
		lmin[0] = NOT_EXIST;
		for (int i = 1; i < numbers.length; i++) {
			if (min == NOT_EXIST || numbers[i - 1] < numbers[min]) {
				min = i - 1;
			}
			lmin[i] = min;
		}
		return lmin;
	}

	private int[] rmax(int[] numbers) {
		int[] rmax = new int[numbers.length];
		int max = NOT_EXIST;
		rmax[numbers.length - 1] = NOT_EXIST;
		for (int i = numbers.length - 2; i >= 0; i--) {
			if (max == NOT_EXIST || numbers[i + 1] > numbers[max]) {
				max = i + 1;
			}
			rmax[i] = max;
		}
		return rmax;
	}
}
