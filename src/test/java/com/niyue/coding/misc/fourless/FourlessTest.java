package com.niyue.coding.misc.fourless;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FourlessTest {

	@Test
	public void test5() {
		Fourless f = new Fourless();
		int result = f.translate(5);
		assertThat(result, is(4));
	}
	
	@Test
	public void test10() {
		Fourless f = new Fourless();
		int result = f.translate(10);
		assertThat(result, is(9));
	}
	
	@Test
	public void test13() {
		Fourless f = new Fourless();
		int result = f.translate(13);
		assertThat(result, is(12));
	}
	
	@Test
	public void test15() {
		Fourless f = new Fourless();
		int result = f.translate(15);
		assertThat(result, is(13));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test14() {
		Fourless f = new Fourless();
		f.translate(14);
	}
	
	@Test
	public void testMinusOne() {
		Fourless f = new Fourless();
		int result = f.translate(-1);
		assertThat(result, is(-1));
	}
	
	@Test
	public void testMinusFive() {
		Fourless f = new Fourless();
		int result = f.translate(-5);
		assertThat(result, is(-4));
	}
	
	@Test
	public void testIntegerValueOf11() {
		int result = Integer.valueOf("10", 11);
		assertThat(result, is(11));
	}
	
	@Test
	public void test10IntegerValueOf11() {
		int result = Integer.valueOf("a", 11);
		assertThat(result, is(10));
	}
	
	@Test
	public void test19IntegerValueOf20() {
		int result = Integer.valueOf("j", 20);
		assertThat(result, is(19));
	}
	
	@Test
	public void test35IntegerValueOf36() {
		int result = Integer.valueOf("z", Character.MAX_RADIX);
		assertThat(result, is(35));
	}
}
