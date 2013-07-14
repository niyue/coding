package com.niyue.coding.misc.longdivision;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class LongDivisionTest {

	@Test
	public void test1Over3() {
		LongDivision ld = new LongDivision();
		String result = ld.divide(1, 3);
		assertThat(result, is("0.(3)"));
	}
	
	@Test
	public void test1Over6() {
		LongDivision ld = new LongDivision();
		String result = ld.divide(1, 6);
		assertThat(result, is("0.1(6)"));
	}
	
	@Test
	public void test1Over5() {
		LongDivision ld = new LongDivision();
		String result = ld.divide(1, 5);
		assertThat(result, is("0.2(0)"));
	}
	
	@Test
	public void test1Over4() {
		LongDivision ld = new LongDivision();
		String result = ld.divide(1, 4);
		assertThat(result, is("0.25(0)"));
	}
	
	@Test
	public void test1Over7() {
		LongDivision ld = new LongDivision();
		String result = ld.divide(1, 7);
		assertThat(result, is("0.(142857)"));
	}
	
	@Test
	public void test1Over70() {
		LongDivision ld = new LongDivision();
		String result = ld.divide(1, 70);
		assertThat(result, is("0.0(142857)"));
	}
	
	@Test
	public void test16Over7() {
		LongDivision ld = new LongDivision();
		String result = ld.divide(16, 7);
		assertThat(result, is("2.(285714)"));
	}
	
	@Test
	public void test1Over11() {
		LongDivision ld = new LongDivision();
		String result = ld.divide(1, 11);
		assertThat(result, is("0.(09)"));
	}
}
