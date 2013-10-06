package com.niyue.coding.leetcode.substringconcatenation;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SubstringConcatenationTwoTest {

	@Test
	// index out of bound, i + wordLength should be less than S.length
	public void testProvidedTestCase() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Integer> starts = sl.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"});
		assertEquals(2, starts.size());
		assertEquals(0, (int) starts.get(0));
		assertEquals(9, (int) starts.get(1));
	}
	
	@Test
	// edge case when i + wordLength == S.length
	public void testSingleCharacterString() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Integer> starts = sl.findSubstring("a", new String[] {"a"});
		assertEquals(1, starts.size());
		assertEquals(0, (int) starts.get(0));
	}
	
	@Test
	// edge case when i + wordLength == S.length
	public void testDuplicateWordsInL() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Integer> starts = sl.findSubstring("a", new String[] {"a", "a"});
		assertEquals(0, starts.size());
	}
	
	@Test
	// removing duplicated word twice
	public void testDuplicateWordsInS() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Integer> starts = sl.findSubstring("aaa", new String[] {"a", "b"});
		assertEquals(0, starts.size());
	}
	
	@Test
	// should use LinkedHashMap instead of HashMap
	public void testLong() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Integer> starts = sl.findSubstring("ofooowingdingbarrwing", new String[] {"fooo","barr","wing","ding","wing"});
		assertEquals(1, starts.size());
	}
	
	@Test
	public void testOverlappedWordsInSAndDuplicateWordsInL() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Integer> starts = sl.findSubstring("aaa", new String[] {"aa", "aa"});
		assertThat(starts.isEmpty(), is(true));
	}
	
	@Test
	public void testInterleavingWordsInS() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Integer> starts = sl.findSubstring("abab", new String[] {"a", "b"});
		assertThat(starts, is(Arrays.asList(0, 1, 2)));
	}
	
	@Test
	public void testInterleavingWordsInSAndDuplicatedInL() {
		SolutionTwo sl = new SolutionTwo();
		ArrayList<Integer> starts = sl.findSubstring("abababab", new String[] {"a", "b", "a"});
		assertThat(starts, is(Arrays.asList(0, 2, 4)));
	}
}
