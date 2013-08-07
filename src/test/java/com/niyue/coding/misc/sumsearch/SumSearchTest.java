package com.niyue.coding.misc.sumsearch;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class SumSearchTest {
	
	@Test
	public void testOneElementNotEqual() {
		SumSearch ss = new SumSearch();
		int k = ss.search(new int[] {5},  11);
		assertThat(k, is(-1));
	}
	
	@Test
	public void testOneElementEqual() {
		SumSearch ss = new SumSearch();
		int k = ss.search(new int[] {5},  5);
		assertThat(k, is(5));
	}

	@Test
	public void testTwoElements() {
		SumSearch ss = new SumSearch();
		int k = ss.search(new int[] {5, 7},  11);
		assertThat(k, is(6));
	}
	
	@Test
	public void testExistingEqualSum() {
		SumSearch ss = new SumSearch();
		int k = ss.search(new int[] {5, 7},  12);
		assertThat(k, is(7));
	}
	
	@Test
	public void testGivenExample() {
		SumSearch ss = new SumSearch();
		int k = ss.search(new int[] {1, 2, 5, 7, 7, 8},  26);
		assertThat(k, is(6));
	}
	
	@Test
	public void testAllEqualNumbers() {
		SumSearch ss = new SumSearch();
		int k = ss.search(new int[] {6, 6, 6},  18);
		assertThat(k, is(6));
	}
	
	@Test
	public void testNoSolution() {
		SumSearch ss = new SumSearch();
		int k = ss.search(new int[] {6, 6, 6},  19);
		assertThat(k, is(-1));
	}

}
