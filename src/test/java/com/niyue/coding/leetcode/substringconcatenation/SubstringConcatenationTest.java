package com.niyue.coding.leetcode.substringconcatenation;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class SubstringConcatenationTest {

	@Test
	// index out of bound, i + wordLength should be less than S.length
	public void testProvidedTestCase() {
		Solution sl = new Solution();
		ArrayList<Integer> starts = sl.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"});
		assertEquals(2, starts.size());
		assertEquals(0, (int) starts.get(0));
		assertEquals(9, (int) starts.get(1));
	}
	
	@Test
	// edge case when i + wordLength == S.length
	public void testSingleCharacterString() {
		Solution sl = new Solution();
		ArrayList<Integer> starts = sl.findSubstring("a", new String[] {"a"});
		assertEquals(1, starts.size());
		assertEquals(0, (int) starts.get(0));
	}
	
	@Test
	// edge case when i + wordLength == S.length
	public void testDuplicateWordsInL() {
		Solution sl = new Solution();
		ArrayList<Integer> starts = sl.findSubstring("a", new String[] {"a", "a"});
		assertEquals(0, starts.size());
	}
	
	@Test
	// removing duplicated word twice
	public void testDuplicateWordsInS() {
		Solution sl = new Solution();
		ArrayList<Integer> starts = sl.findSubstring("aaa", new String[] {"a", "b"});
		assertEquals(0, starts.size());
	}
	
	@Test
	// should use LinkedHashMap instead of HashMap
	public void testLong() {
		Solution sl = new Solution();
		ArrayList<Integer> starts = sl.findSubstring("ofooowingdingbarrwing", new String[] {"fooo","barr","wing","ding","wing"});
		assertEquals(1, starts.size());
	}
}
