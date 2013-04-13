package com.niyue.coding.leetcode.textjustification;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TextJustificationTest {

	@Test
	// use StringBuilder.deleteCharAt instead of StringBuilder.substring
	public void testEmptyString() {
		Solution sl = new Solution();
		ArrayList<String> lines = sl.fullJustify(new String[] {""}, 0);
		assertEquals(1, lines.size());
		assertEquals("", lines.get(0));
	}
	
	@Test
	// if-else in loop is incorrect
	public void testTwo() {
		Solution sl = new Solution();
		ArrayList<String> lines = sl.fullJustify(new String[] {"a", "b"}, 1);
		assertEquals(2, lines.size());
		assertEquals("a", lines.get(0));
		assertEquals("b", lines.get(1));
	}
	
	@Test
	public void testTwoSingleSeparatedByOneSpace() {
		Solution sl = new Solution();
		ArrayList<String> lines = sl.fullJustify(new String[] {"a", "b", "c", "d", "e"}, 3);
		assertEquals(3, lines.size());
		assertEquals("a b", lines.get(0));
		assertEquals("c d", lines.get(1));
		assertEquals("e  ", lines.get(2));
	}
	
	@Test
	// the last spaces should not be added
	public void testSpeakToAFew() {
		Solution sl = new Solution();
		ArrayList<String> lines = sl.fullJustify(new String[] {"to", "a", "few."}, 6);
		assertEquals(2, lines.size());
		assertEquals("to   a", lines.get(0));
		assertEquals("few.  ", lines.get(1));
	}
}
