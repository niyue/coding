package com.niyue.coding.careercup.propotionalrandomness;

import java.util.Arrays;
import java.util.Random;
/*
 * If you're given a list of countries and its corresponding population, 
 * write a function that will return a random country but the higher the population of the country, 
 * the more likely it is to be picked at random.
 * http://www.careercup.com/question?id=14582824
 */
public class PropotionalRandomness {
	
	public int select(int[] populations) {
		long[] sums = sum(populations);
		// pick 1 in range [1,maxSum]
		long random = randomLong(sums[sums.length - 1]) + 1;
		// binary search the one picked to map it to a country
		int index = Arrays.binarySearch(sums, random);
		int country = index >= 0 
				? index
				: (index * -1) - 1;
		return country;
	}
	
	// generate a random in the range [0, max - 1]
	private long randomLong(long max) {
		Random ran = new Random();
		return (long) (ran.nextDouble() * max);
	}
	
	// world population, 7 billion, cannot fit into a 32-bit integer
	private long[] sum(int[] populations) {
		long sums[] = new long[populations.length];
		for(int i = 0; i < sums.length; i++) {
			long prev = i == 0 ? 0 : sums[i - 1];
			sums[i] = populations[i] + prev;
		}
		return sums;
	}
}
