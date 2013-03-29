package com.niyue.coding.leetcode.lettercombinations;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class LetterCombinationsTest {

	@Test
	// base case can be simplified, incorrect char-int conversion
	public void test2() {
		Solution sl = new Solution();
		List<String> combinations = sl.letterCombinations("2");
		assertEquals(3, combinations.size());
	}
}
