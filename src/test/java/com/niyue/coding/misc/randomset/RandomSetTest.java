package com.niyue.coding.misc.randomset;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class RandomSetTest {

	@Test
	public void testEmptySetContains() {
		RandomSet<Integer> set = new RandomSet<Integer>();
		assertThat(set.contains(1), is(false));
	}
	
	@Test
	public void testSetContains() {
		RandomSet<Integer> set = new RandomSet<Integer>();
		set.add(1);
		assertThat(set.size(), is(1));
		assertThat(set.contains(1), is(true));
	}
	
	@Test
	public void testSetAddSameElement() {
		RandomSet<Integer> set = new RandomSet<Integer>();
		set.add(1);
		assertThat(set.size(), is(1));
		assertThat(set.contains(1), is(true));
		set.add(1);
		assertThat(set.size(), is(1));
		assertThat(set.contains(1), is(true));
	}
	
	@Test
	public void testSetAddAndRemove() {
		RandomSet<Integer> set = new RandomSet<Integer>();
		set.add(1);
		assertThat(set.size(), is(1));
		assertThat(set.contains(1), is(true));
		set.add(2);
		assertThat(set.size(), is(2));
		assertThat(set.contains(2), is(true));
		int removed = set.remove(2);
		assertThat(removed, is(2));
		assertThat(set.size(), is(1));
		assertThat(set.contains(2), is(false));
	}
}
