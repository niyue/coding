package com.niyue.coding.leetcode.searchrotatedsortedarray;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SearchRotatedSortedArrayTest {

	@Test
	public void testSearchEmptyArray() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {}, 1);
		assertThat(index, is(-1));
	}
	
	@Test
	public void testSearchSingleElementArray() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {1}, 1);
		assertThat(index, is(0));
	}
	
	@Test
	public void testSearchSingleElementArrayNotFound() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {0}, 1);
		assertThat(index, is(-1));
	}
	
	@Test
	public void testSearchUnrotatedTwoElementsArray() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {0, 1}, 1);
		assertThat(index, is(1));
	}
	
	@Test
	public void testSearchRotatedTwoElementsArray() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {1, 0}, 1);
		assertThat(index, is(0));
	}
	
	@Test
	public void testSearchSecondHalfOfRotatedTwoElementsArray() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {1, 0}, 0);
		assertThat(index, is(1));
	}

	@Test
	public void testSearchUnrotatedThreeElementsArray() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {0, 1, 2}, 2);
		assertThat(index, is(2));
	}
	
	@Test
	public void testSearchRotatedThreeElementsArray() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {1, 2, 0}, 2);
		assertThat(index, is(1));
	}
	
	@Test
	public void testSearchLastInRotatedThreeElementsArray() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {1, 2, 0}, 0);
		assertThat(index, is(2));
	}
	
	@Test
	public void testSearchPeak() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 7);
		assertThat(index, is(3));
	}
	
	@Test
	public void testSearchFirst() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 4);
		assertThat(index, is(0));
	}
	
	@Test
	public void testSearchLast() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 2);
		assertThat(index, is(6));
	}
	
	@Test
	public void testSearchNextToRotatingPoint() {
		SolutionTwo sl = new SolutionTwo();
		int index = sl.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0);
		assertThat(index, is(4));
	}
}
