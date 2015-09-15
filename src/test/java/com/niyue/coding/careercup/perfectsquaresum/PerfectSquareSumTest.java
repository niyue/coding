package com.niyue.coding.careercup.perfectsquaresum;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PerfectSquareSumTest {

	@Test
	public void testOne() {
		PerfectSquareSum pss = new PerfectSquareSum();
		int n = pss.leastNumberOfPerfectSequares(1);
		assertThat(n, is(1));
	}
	
	@Test
	public void testTwo() {
		PerfectSquareSum pss = new PerfectSquareSum();
		int n = pss.leastNumberOfPerfectSequares(2);
		assertThat(n, is(2));
	}
	
	@Test
	public void testThree() {
		PerfectSquareSum pss = new PerfectSquareSum();
		int n = pss.leastNumberOfPerfectSequares(3);
		assertThat(n, is(3));
	}
	
	@Test
	public void testFour() {
		PerfectSquareSum pss = new PerfectSquareSum();
		int n = pss.leastNumberOfPerfectSequares(4);
		assertThat(n, is(1));
	}
	
	@Test
	public void testFive() {
		PerfectSquareSum pss = new PerfectSquareSum();
		int n = pss.leastNumberOfPerfectSequares(5);
		assertThat(n, is(2));
	}
	
	@Test
	public void testSix() {
		PerfectSquareSum pss = new PerfectSquareSum();
		int n = pss.leastNumberOfPerfectSequares(6);
		assertThat(n, is(3));
	}
	
	@Test
	public void test12() {
		PerfectSquareSum pss = new PerfectSquareSum();
		int n = pss.leastNumberOfPerfectSequares(12);
		assertThat(n, is(3));
	}
}
