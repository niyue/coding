package com.niyue.coding.careercup.dictsort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.Is.is;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DictSortTest {

	@Test
	// a < b < c
	public void testSingleCharDict() {
		List<String> dict = Arrays.asList(
			"a",
			"b",
			"c"
		);
		DictSort dictSort = new DictSort();
		String sort = dictSort.sort("bcca", dict);
		assertEquals("abcc", sort);
	}
	
	@Test
	// a < b, a < c
	public void testALBAndALCDict() {
		List<String> dict = Arrays.asList(
			"aa",
			"ab",
			"ca"
		);
		DictSort dictSort = new DictSort();
		String sort = dictSort.sort("bcca", dict);
		assertEquals("abcc", sort);
	}
	
	@Test
	// a < b, c < b
	public void testALBAndCLBDict() {
		List<String> dict = Arrays.asList(
			"aa",
			"abc",
			"abb"
		);
		DictSort dictSort = new DictSort();
		String sort = dictSort.sort("bcca", dict);
		assertThat(sort, anyOf(is("accb"), is("ccab")));
	}
}
