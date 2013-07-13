package com.niyue.coding.misc.nestedlist;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class NestedListTest {

	@Test
	public void testOneInteger() {
		NestedList list = new NestedList(1);
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(1));
		assertThat(list.hasNext(), is(false));
	}
	
	@Test
	public void testTwoIntegers() {
		NestedList list = new NestedList(1, 2);
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(1));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(2));
		assertThat(list.hasNext(), is(false));
	}
	
	@Test
	public void testOneList() {
		NestedList list = new NestedList(Arrays.asList(1, 2));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(1));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(2));
		assertThat(list.hasNext(), is(false));
	}
	
	@Test
	public void testTwoLists() {
		NestedList list = new NestedList(Arrays.asList(1, 2), Arrays.asList(3, 4));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(1));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(2));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(3));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(4));
		assertThat(list.hasNext(), is(false));
	}
	
	@Test
	public void testOneIntegerAndOneList() {
		NestedList list = new NestedList(1, Arrays.asList(2, 3));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(1));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(2));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(3));
		assertThat(list.hasNext(), is(false));
	}
	
	@Test
	public void testEmptyList() {
		NestedList list = new NestedList(Collections.emptyList());
		assertThat(list.hasNext(), is(false));
	}
	
	@Test
	public void testOneIntegerAndEmptyList() {
		NestedList list = new NestedList(1, Collections.emptyList());
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(1));
		assertThat(list.hasNext(), is(false));
	}
	
	@Test
	public void testOneListAndEmptyList() {
		NestedList list = new NestedList(Arrays.asList(1, 2), Collections.emptyList());
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(1));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(2));
		assertThat(list.hasNext(), is(false));
	}
	
	@Test
	public void testOneListAndEmptyListAndOneList() {
		NestedList list = new NestedList(Arrays.asList(1, 2), Collections.emptyList(), Arrays.asList(3, 4, 5));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(1));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(2));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(3));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(4));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(5));
		assertThat(list.hasNext(), is(false));
	}
	
	@Test
	public void testMultipleEmptyLists() {
		NestedList list = new NestedList(Collections.emptyList(), Collections.emptyList(), Arrays.asList(1, 2), Collections.emptyList(), Collections.emptyList(), Arrays.asList(3, 4, 5));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(1));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(2));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(3));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(4));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(5));
		assertThat(list.hasNext(), is(false));
	}
	
	@Test
	public void testMixIntegerAndList() {
		NestedList list = new NestedList(Arrays.asList(1, 2), 3, Collections.emptyList(), Collections.emptyList(), Arrays.asList(4, 5, 6), Collections.emptyList());
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(1));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(2));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(3));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(4));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(5));
		assertThat(list.hasNext(), is(true));
		assertThat(list.next(), is(6));
		assertThat(list.hasNext(), is(false));
	}
}
