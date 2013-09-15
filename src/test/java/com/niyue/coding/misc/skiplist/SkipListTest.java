package com.niyue.coding.misc.skiplist;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Set;

import org.junit.Test;

public class SkipListTest {

	@Test
	public void testAdd() {
		Set<Integer> skipList = new SkipList<Integer>();
		skipList.add(1);
		assertThat(skipList.size(), is(1));
	}
	
	@Test
	public void testContains() {
		Set<Integer> skipList = new SkipList<Integer>();
		skipList.add(1);
		assertThat(skipList.size(), is(1));
		assertThat(skipList.contains(1), is(true));
	}
	
	@Test
	public void testAddTwoElements() {
		Set<Integer> skipList = new SkipList<Integer>();
		skipList.add(1);
		skipList.add(3);
		assertThat(skipList.size(), is(2));
		assertThat(skipList.contains(1), is(true));
		if(!skipList.contains(3)) {
			assertThat(skipList.contains(3), is(true));
		}
	}

}
