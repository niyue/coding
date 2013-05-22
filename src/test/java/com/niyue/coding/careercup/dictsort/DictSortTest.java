package com.niyue.coding.careercup.dictsort;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;

public class DictSortTest {

	@Test
	public void testSingleCharDict() {
		SortedSet<String> dict = new TreeSet<String>(Arrays.asList(
			"a",
			"b",
			"c"
		));
		DictSort dictSort = new DictSort();
		String sort = dictSort.sort("bcca", dict);
		assertEquals("abcc", sort);
	}
}
