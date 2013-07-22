package com.niyue.coding.misc.charsort;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class CharSortTest {

	@Test
	public void testSortOneChar() {
		CharSort sort = new CharSort();
		String order = sort.sort("s", "s");
		assertThat(order, is("s"));
	}
	
	@Test
	public void testSortOneCharWithOrder() {
		CharSort sort = new CharSort();
		String order = sort.sort("as", "s");
		assertThat(order, is("sa"));
	}
	
	@Test
	public void testSortTwoCharWithOrder() {
		CharSort sort = new CharSort();
		String order = sort.sort("abs", "sa");
		assertThat(order, is("sab"));
	}
	
	@Test
	public void testSortMultipleChars() {
		CharSort sort = new CharSort();
		String order = sort.sort("house", "soup");
		assertThat(order, is("soueh"));
	}
}
