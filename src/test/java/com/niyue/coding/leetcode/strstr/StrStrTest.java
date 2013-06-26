package com.niyue.coding.leetcode.strstr;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StrStrTest {

	@Test
	public void testEmptyString() {
		Solution sl = new Solution();
		String result = sl.strStr("", "");
		assertThat(result, is(""));
	}
	
	@Test
	public void testSingleChar() {
		Solution sl = new Solution();
		String result = sl.strStr("a", "a");
		assertThat(result, is("a"));
	}
	
	@Test
	public void testSingleCharAndEmpty() {
		Solution sl = new Solution();
		String result = sl.strStr("a", "");
		assertThat(result, is("a"));
	}
	
	@Test
	public void testFirstChar() {
		Solution sl = new Solution();
		String result = sl.strStr("aa", "a");
		assertThat(result, is("aa"));
	}
}
