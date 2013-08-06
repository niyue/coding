package com.niyue.coding.misc.evenoddstrings;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class EvenOddStringsTest {

	@Test
	public void testOneString() {
		EvenOddStrings eos = new EvenOddStrings();
		String oddString = eos.findOdd(new String[] {"hello"});
		assertThat(oddString, is("hello"));
	}
	
	@Test
	public void testTwoDifferentStrings() {
		EvenOddStrings eos = new EvenOddStrings();
		String oddString = eos.findOdd(new String[] {"world", "hello", "world"});
		assertThat(oddString, is("hello"));
	}
	
	@Test
	public void testThreeDifferentStrings() {
		EvenOddStrings eos = new EvenOddStrings();
		String oddString = eos.findOdd(new String[] {"world", "you", "you", "you", "you", "hello", "world"});
		assertThat(oddString, is("hello"));
	}
	
	@Test
	public void testTwoChineseStrings() {
		EvenOddStrings eos = new EvenOddStrings();
		String oddString = eos.findOdd(new String[] {"世界", "hello", "世界"});
		assertThat(oddString, is("hello"));
	}

}
