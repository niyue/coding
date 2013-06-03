package com.niyue.coding.careercup.blacklistrandomgenerator;

import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BlackListRandomGeneratorTest {

	@Test
	public void testGenerateRandoms() {
		List<Integer> blackList = Arrays.asList(2, 10, 15, 20, 22, 28, 75, 99);
		BlackListRandomGenerator random = new BlackListRandomGenerator();
		int size = 100;
		int[] frequency = new int[size + 1];
		for(int i = 0; i < 2000; i++) {
			int number = random.generate(size, blackList);
			frequency[number]++;
			assertFalse(blackList.contains(number));
		}
//		for(int i = 1; i <= size; i++) {
//			System.out.format("%s: %s\n", i, frequency[i]);
//		}
	}
}
