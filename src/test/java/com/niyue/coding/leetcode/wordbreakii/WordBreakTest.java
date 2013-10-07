package com.niyue.coding.leetcode.wordbreakii;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class WordBreakTest {

	@Test
	public void testEmptyDict() {
		Solution sl = new Solution();
		List<String> solutions = sl.wordBreak("a", new HashSet<String>());
		assertThat(solutions.isEmpty(), is(true));
	}

	@Test
	public void testOneWordDict() {
		Solution sl = new Solution();
		List<String> solutions = sl.wordBreak(
				"a", 
				new HashSet<String>(Arrays.asList("a")));
		assertThat(solutions, is(Arrays.asList("a")));
	}
	
	@Test
	public void testTwoWordsDict() {
		Solution sl = new Solution();
		List<String> solutions = sl.wordBreak(
				"helloworld", 
				new HashSet<String>(Arrays.asList("hello", "world")));
		assertThat(solutions, is(Arrays.asList("hello world")));
	}
}
