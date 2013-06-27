package com.niyue.coding.careercup.tribonacci;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MatrixTribonacciTest {

	@Test
	public void test1() {
		MatrixTribonacci trib = new MatrixTribonacci();
		long nth = trib.get(1);
		assertThat(nth, is(1L));
	}
	
	@Test
	public void test2() {
		MatrixTribonacci trib = new MatrixTribonacci();
		long nth = trib.get(2);
		assertThat(nth, is(2L));
	}
	
	@Test
	public void test3() {
		MatrixTribonacci trib = new MatrixTribonacci();
		long nth = trib.get(3);
		assertThat(nth, is(4L));
	}
	
	@Test
	public void test4() {
		MatrixTribonacci trib = new MatrixTribonacci();
		long nth = trib.get(4);
		assertThat(nth, is(7L));
	}
	
	@Test
	public void test5() {
		MatrixTribonacci trib = new MatrixTribonacci();
		long nth = trib.get(5);
		assertThat(nth, is(13L));
	}
	
	@Test
	public void test6() {
		MatrixTribonacci trib = new MatrixTribonacci();
		long nth = trib.get(6);
		assertThat(nth, is(24L));
	}
	
	@Test
	public void test10() {
		MatrixTribonacci trib = new MatrixTribonacci();
		long nth = trib.get(10);
		assertThat(nth, is(274L));
	}
}
