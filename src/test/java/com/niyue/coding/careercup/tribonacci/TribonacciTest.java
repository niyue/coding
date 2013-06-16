package com.niyue.coding.careercup.tribonacci;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TribonacciTest {

	@Test
	public void test1() {
		Tribonacci trib = new Tribonacci();
		long nth = trib.get(1);
		assertThat(nth, is(1L));
	}
	
	@Test
	public void test2() {
		Tribonacci trib = new Tribonacci();
		long nth = trib.get(2);
		assertThat(nth, is(2L));
	}
	
	@Test
	public void test3() {
		Tribonacci trib = new Tribonacci();
		long nth = trib.get(3);
		assertThat(nth, is(4L));
	}
	
	@Test
	// prev[0,1,2] should be used instead of prev[i-3,i-2,i-1]
	public void test4() {
		Tribonacci trib = new Tribonacci();
		long nth = trib.get(4);
		assertThat(nth, is(7L));
	}
	
	@Test
	public void test5() {
		Tribonacci trib = new Tribonacci();
		long nth = trib.get(5);
		assertThat(nth, is(13L));
	}
	
	@Test
	public void test6() {
		Tribonacci trib = new Tribonacci();
		long nth = trib.get(6);
		assertThat(nth, is(24L));
	}
	
	@Test
	public void test10() {
		Tribonacci trib = new Tribonacci();
		long nth = trib.get(10);
		assertThat(nth, is(274L));
	}
}
