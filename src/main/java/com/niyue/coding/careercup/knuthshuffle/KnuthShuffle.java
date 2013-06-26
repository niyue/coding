package com.niyue.coding.careercup.knuthshuffle;

import java.util.Random;

// http://www.careercup.com/question?id=291796
// An in-place version of knuth shuffle
public class KnuthShuffle {
	public int[] shuffle(int[] numbers) {
		Random rand = new Random();
		for(int i = numbers.length - 1; i >= 1; i--) {
			int random = rand.nextInt(i + 1);
			swap(numbers, random, i);
		}
		return numbers;
	}
	
	private void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
