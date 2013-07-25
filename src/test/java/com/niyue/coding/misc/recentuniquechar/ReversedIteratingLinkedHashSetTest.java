package com.niyue.coding.misc.recentuniquechar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

public class ReversedIteratingLinkedHashSetTest {

	@Test
	public void testInsertOneElementToSet() {
		Set<Integer> set = new ReversedIteratingLinkedHashSet<>();
		set.add(1);
		assertThat(set.iterator().next(), is(1));
	}
	
	@Test
	public void testInsertTwoElementsToSet() {
		Set<Integer> set = new ReversedIteratingLinkedHashSet<>();
		set.add(1);
		assertThat(set.iterator().next(), is(1));
		set.add(2);
		assertThat(set.iterator().next(), is(2));
	}
	
	@Test
	public void testInsertThreeElementsToSet() {
		Set<Integer> set = new ReversedIteratingLinkedHashSet<>();
		set.add(1);
		assertThat(set.iterator().next(), is(1));
		set.add(2);
		Iterator<Integer> iter = set.iterator();
		assertThat(iter.next(), is(2));
		assertThat(iter.next(), is(1));
		set.add(3);
		assertThat(set.iterator().next(), is(3));
		iter = set.iterator();
		assertThat(iter.next(), is(3));
		assertThat(iter.next(), is(2));
		assertThat(iter.next(), is(1));
	}
	
	@Test
	public void testInsertThreeElementsAndRemoveOneToSet() {
		Set<Integer> set = new ReversedIteratingLinkedHashSet<>();
		set.add(1);
		assertThat(set.iterator().next(), is(1));
		set.add(2);
		assertThat(set.iterator().next(), is(2));
		set.add(3);
		assertThat(set.iterator().next(), is(3));
		set.remove(3);
		Iterator<Integer> iter = set.iterator();
		assertThat(iter.next(), is(2));
		assertThat(iter.next(), is(1));
		assertThat(set.iterator().next(), is(2));
	}
	
	@Test
	public void testMixOperationsForSet() {
		Set<Integer> set = new ReversedIteratingLinkedHashSet<>();
		set.add(1);
		assertThat(set.iterator().next(), is(1));
		set.add(2);
		assertThat(set.iterator().next(), is(2));
		set.add(3);
		assertThat(set.iterator().next(), is(3));
		set.remove(3);
		assertThat(set.iterator().next(), is(2));
		set.add(3);
		assertThat(set.iterator().next(), is(3));
		set.add(2);
		assertThat(set.iterator().next(), is(3));
		
		set.remove(2);
		assertThat(set.iterator().next(), is(3));
		set.remove(3);
		assertThat(set.iterator().next(), is(1));
	}
}
