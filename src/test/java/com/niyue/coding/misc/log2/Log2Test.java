package com.niyue.coding.misc.log2;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Log2Test {

	@Test
	public void test4() {
		Log2 log = new Log2();
		double log2 = log.log2(4);
		assertThat(log2, closeTo(2, 0.00001));
	}
	
	@Test
	public void test1() {
		Log2 log = new Log2();
		double log2 = log.log2(1);
		assertThat(log2, closeTo(0, 0.00001));
	}
	
	@Test
	public void test1414() {
		Log2 log = new Log2();
		double log2 = log.log2(1.414);
		assertThat(log2, closeTo(0.5, 0.01));
	}
	
	@Test
	public void testPoint5() {
		Log2 log = new Log2();
		double log2 = log.log2(0.5);
		assertThat(log2, closeTo(-1, 0.00001));
	}
}
