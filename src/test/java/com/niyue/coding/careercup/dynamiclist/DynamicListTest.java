package com.niyue.coding.careercup.dynamiclist;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Test;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
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
	
	@Test
	public void testContains() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		assertThat(list.size(), is(2));
		assertThat(list, hasItem(3));
		assertThat(list, not(hasItem(4)));
	}
	
	@Test
	public void testContainsAll() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		assertThat(list.size(), is(3));
		assertThat(list.containsAll(Arrays.asList(2, 4)), is(true));
	}
	
	@Test
	public void testLastIndexOf() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		assertThat(list.size(), is(4));
		assertThat(list.lastIndexOf(3), is(2));
	}
	
	@Test
	public void testRemove() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		assertThat(list.size(), is(5));
		assertThat(list.remove((Integer) 4), is(true));
		assertThat(list.size(), is(4));
		assertThat(list.remove((Integer) 10), is(false));
		assertThat(list.size(), is(4));
	}
	
	@Test
	public void testRemoveByIndex() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		assertThat(list.size(), is(5));
		assertThat(list.remove(0), is(2));
		assertThat(list.size(), is(4));
		assertThat(list.remove(1), is(3));
		assertThat(list.size(), is(3));
	}
	
	@Test
	public void testRemoveAll() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(4);
		list.add(5);
		assertThat(list.size(), is(5));
		assertThat(list.removeAll(Arrays.asList(4, 2)), is(true));
		assertThat(list.size(), is(3));
		assertThat(list.contains(2), is(false));
		assertThat(list.contains(4), is(false));
	}
	
	@Test
	public void testToArray() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		assertThat(list.toArray(new Integer[] {}), is(new Integer[] {2, 3, 4}));
	}
	
	@Test
	public void testToLargeArray() {
		DynamicList<Integer> list = new DynamicList<Integer>();
		list.add(2);
		list.add(3);
		list.add(4);
		assertThat(list.toArray(new Integer[4]), is(new Integer[] {2, 3, 4, null}));
	}
}
