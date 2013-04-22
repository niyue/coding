package com.niyue.coding.careercup.longesttwocharsstring;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestTwoCharsStringTest {

	@Test
	public void testSingleCharString() {
		LongestTwoCharsString sl = new LongestTwoCharsString();
		String string = sl.longestTwoCharsString("a");
		assertEquals("a", string);
	}
	
	@Test
	public void testTwoCharsString() {
		LongestTwoCharsString sl = new LongestTwoCharsString();
		String string = sl.longestTwoCharsString("aa");
		assertEquals("aa", string);
	}
	
	@Test
	public void testThreeCharsString() {
		LongestTwoCharsString sl = new LongestTwoCharsString();
		String string = sl.longestTwoCharsString("aaa");
		assertEquals("aaa", string);
	}
	
	@Test
	public void testThreeCharsTwoDifferentCharsString() {
		LongestTwoCharsString sl = new LongestTwoCharsString();
		String string = sl.longestTwoCharsString("aab");
		assertEquals("aab", string);
	}
	
	@Test
	public void testRepeatitiveString() {
		LongestTwoCharsString sl = new LongestTwoCharsString();
		String string = sl.longestTwoCharsString("aabbc");
		assertEquals("aabb", string);
	}
	
	@Test
	public void testSampleString() {
		LongestTwoCharsString sl = new LongestTwoCharsString();
		String string = sl.longestTwoCharsString("aabbcbbbadef");
		assertEquals("bbcbbb", string);
	}
}
