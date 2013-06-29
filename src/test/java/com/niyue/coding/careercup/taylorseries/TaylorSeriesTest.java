package com.niyue.coding.careercup.taylorseries;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
public class TaylorSeriesTest {

	@Test
	public void testZero() {
		TaylorSeries ts = new TaylorSeries();
		double exp = ts.evaluate(0);
		assertThat(exp, closeTo(1, 0.00001));
	}
	
	@Test
	public void testOne() {
		TaylorSeries ts = new TaylorSeries();
		double exp = ts.evaluate(1);
		assertThat(exp, closeTo(2.71828, 0.00001));
	}
	
	@Test
	public void testSquare() {
		TaylorSeries ts = new TaylorSeries();
		double exp = ts.evaluate(2);
		assertThat(exp, closeTo(7.38905609, 0.00001));
	}
}
