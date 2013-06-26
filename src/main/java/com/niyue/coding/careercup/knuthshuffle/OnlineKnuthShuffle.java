package com.niyue.coding.careercup.knuthshuffle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// http://www.careercup.com/question?id=291796
// http://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
// An online version of knuth shuffle without knowing the size of the array to be shuffled up front
public class OnlineKnuthShuffle {
	public List<Integer> shuffle(Iterator<Integer> source) {
		List<Integer> result = new ArrayList<Integer>();
		Random rand = new Random();
		while(source.hasNext()) {
			int random = rand.nextInt(result.size() + 1);
			int next = source.next();
			result.add(next);
			swap(result, random, result.size() - 1);
		}
		return result;
	}
	
	private void swap(List<Integer> numbers, int i, int j) {
		int temp = numbers.get(i);
		numbers.set(i, numbers.get(j));
		numbers.set(j, temp);
	}
}
