package com.niyue.coding.careercup.dynamiclist;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;

public class DynamicListTest {

	@Test
	public void testAdd() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		assertThat(list.size(), is(1));
		assertThat(list.get(0), is(2));
	}
	
	@Test
	public void testAddToResize() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		for(int i = 0; i < 20; i++) {
			list.add(i);
		}
		assertThat(list.size(), is(20));
		assertThat(list.get(9), is(9));
	}
	
	@Test
	public void testAddWithIndex() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(0, -1);
		assertThat(list.size(), is(4));
		//assertThat(list, is(Arrays.asList(-1, 0, 1, 2)));
		// assertThat(list.toArray(new Integer[]{}), is(new Integer[] {-1, 0, 1, 2}));
		assertThat(list.get(0), is(-1));
		assertThat(list.get(1), is(0));
		assertThat(list.get(2), is(1));
		assertThat(list.get(3), is(2));
	}
	
	@Test
	public void testAddAll() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.addAll(Arrays.asList(3, 4));
		assertThat(list.size(), is(3));
		assertThat(list.get(0), is(2));
		assertThat(list.get(1), is(3));
		assertThat(list.get(2), is(4));
	}
	
	@Test
	public void testAddAllWithIndex() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(0);
		list.add(1);
		list.addAll(0, Arrays.asList(3, 4));
		assertThat(list.size(), is(4));
		assertThat(list.get(0), is(3));
		assertThat(list.get(1), is(4));
		assertThat(list.get(2), is(0));
		assertThat(list.get(3), is(1));
	}
	
	@Test
	public void testGetViaIndex() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		assertThat(list.size(), is(2));
		assertThat(list.get(0), is(2));
		assertThat(list.get(1), is(3));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetOutOfBoundIndex() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		assertThat(list.size(), is(2));
		list.get(4);
	}
	
	@Test
	public void testIndexOf() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		assertThat(list.indexOf(3), is(1));
		assertThat(list.indexOf(2), is(0));
	}
	
	@Test
	// null should be handled carefully
	public void testIndexOfNull() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		assertThat(list.indexOf(null), is(-1));
	}
	
	@Test
	public void testIsEmpty() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		assertThat(list.isEmpty(), is(true));
		list.add(2);
		assertThat(list.isEmpty(), is(false));
	}
	
	@Test
	public void testClear() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		assertThat(list.isEmpty(), is(true));
		list.add(2);
		list.add(3);
		assertThat(list.size(), is(2));
		assertThat(list.isEmpty(), is(false));
		list.clear();
		assertThat(list.size(), is(0));
		assertThat(list.isEmpty(), is(true));
	}
	
	@Test
	public void testSetIndex() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		list.set(0, 1);
		assertThat(list.size(), is(2));
		assertThat(list.get(0), is(1));
		assertThat(list.get(1), is(3));
	}
	
	@Test
	public void testIterator() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		assertThat(list.size(), is(3));
		Iterator<Integer> iter = list.iterator();
		int i = 0;
		while(iter.hasNext()) {
			int v = iter.next();
			assertThat(v, is(list.get(i)));
			i++;
		}
		assertThat(i, is(3));
	}
	
	@Test
	public void testIteratorRemove() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		assertThat(list.size(), is(3));
		Iterator<Integer> iter = list.iterator();
		iter.next();
		iter.remove();
		assertThat(list.size(), is(2));
		assertThat(list.get(0), is(1));
		assertThat(list.get(1), is(2));
	}
}
