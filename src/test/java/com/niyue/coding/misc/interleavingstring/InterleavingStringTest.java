package com.niyue.coding.misc.interleavingstring;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Test;

public class InterleavingStringTest {

	@Test
	public void testOneCharAndOneChar() {
		InterleavingString is = new InterleavingString();
		String s = is.interleave(
				new String[]{"a"}, 
				new String[]{"b"});
		assertThat(s, Matchers.is("a"));
	}
	
	@Test
	public void testOneCharAndEmpty() {
		InterleavingString is = new InterleavingString();
		String s = is.interleave(
				new String[]{"a"}, 
				new String[]{""});
		assertThat(s, Matchers.is(""));
	}
	
	@Test
	public void testEmptyAndOneChar() {
		InterleavingString is = new InterleavingString();
		String s = is.interleave(
				new String[]{""}, 
				new String[]{"b"});
		assertThat(s, Matchers.is(""));
	}
	
	@Test
	public void testComplex() {
		InterleavingString is = new InterleavingString();
		String s = is.interleave(
				new String[]{"abc", "mn"}, 
				new String[]{"pa", "d"});
		assertThat(s, Matchers.is("apbacd"));
	}
	
	@Test
	public void testMultipleWithEmptyStringInIt() {
		InterleavingString is = new InterleavingString();
		String s = is.interleave(
				new String[]{"abc", "", "mn", ""}, 
				new String[]{"pa", "", "d"});
		assertThat(s, Matchers.is("apbacd"));
	}
}
