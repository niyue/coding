package com.niyue.coding.careercup.subarraysum;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SubarraySumTest {

	@Test
	public void testOneElement() {
		SubarraySum ss = new SubarraySum();
		int[] result = ss.find(new int[] {1}, 1);
		assertThat(result[0], is(0));
		assertThat(result[1], is(0));
	}
	
	@Test
	public void testTwoElements() {
		SubarraySum ss = new SubarraySum();
		int[] result = ss.find(new int[] {1, 2}, 3);
		assertThat(result[0], is(0));
		assertThat(result[1], is(1));
	}
	
	@Test
	public void testTwoElementsFirstPartSum() {
		SubarraySum ss = new SubarraySum();
		int[] result = ss.find(new int[] {1, 2}, 1);
		assertThat(result[0], is(0));
		assertThat(result[1], is(0));
	}
	
	@Test
	public void testTwoElementsSecondPartSum() {
		SubarraySum ss = new SubarraySum();
		int[] result = ss.find(new int[] {1, 2}, 2);
		assertThat(result[0], is(1));
		assertThat(result[1], is(1));
	}
	
	@Test
	public void testThreeElements() {
		SubarraySum ss = new SubarraySum();
		int[] result = ss.find(new int[] {3, 1, 2}, 4);
		assertThat(result[0], is(0));
		assertThat(result[1], is(1));
	}
	
	@Test
	public void testThreeElementsTrailingElements() {
		SubarraySum ss = new SubarraySum();
		int[] result = ss.find(new int[] {5, 1, 2}, 3);
		assertThat(result[0], is(1));
		assertThat(result[1], is(2));
	}
	
	@Test
	public void testThreeElementsLeadingElements() {
		SubarraySum ss = new SubarraySum();
		int[] result = ss.find(new int[] {5, 1, 2}, 6);
		assertThat(result[0], is(0));
		assertThat(result[1], is(1));
	}
	
	@Test
	public void testThreeElementsAllElements() {
		SubarraySum ss = new SubarraySum();
		int[] result = ss.find(new int[] {5, 1, 2}, 8);
		assertThat(result[0], is(0));
		assertThat(result[1], is(2));
	}

}
