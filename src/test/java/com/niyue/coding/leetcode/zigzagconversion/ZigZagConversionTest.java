package com.niyue.coding.leetcode.zigzagconversion;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ZigZagConversionTest {

	@Test
	public void testOneCharOneRow() {
		SolutionTwo sl = new SolutionTwo();
		String order = sl.convert("a", 1);
		assertThat(order, is("a"));
	}
	
	@Test
	public void testTwoCharOneRow() {
		SolutionTwo sl = new SolutionTwo();
		String order = sl.convert("ab", 1);
		assertThat(order, is("ab"));
	}
	
	@Test
	public void testOneCharTwoRow() {
		SolutionTwo sl = new SolutionTwo();
		String order = sl.convert("a", 2);
		assertThat(order, is("a"));
	}
	
	@Test
	public void testTwoCharsTwoRow() {
		SolutionTwo sl = new SolutionTwo();
		String order = sl.convert("ab", 2);
		assertThat(order, is("ab"));
	}
	
	@Test
	public void testFourCharsTwoRow() {
		SolutionTwo sl = new SolutionTwo();
		String order = sl.convert("abcd", 2);
		assertThat(order, is("acbd"));
	}
	
	@Test
	public void testManyCharsThreeRow() {
		SolutionTwo sl = new SolutionTwo();
		String order = sl.convert("PAYPALISHIRING", 3);
		assertThat(order, is("PAHNAPLSIIGYIR"));
	}

}
