package com.niyue.coding.careercup.twentyfourpoints;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TwentyFourPointsTest {

	@Test
	public void test1234() {
		TwentyFourPoints tfp = new TwentyFourPoints();
		String[] result = tfp.find(1, 2, 3, 4);
		assertThat(result, anyOf(is(new String[] {"1", "*", "2", "*", "3", "*", "4"}), is(new String[] {"4", "*", "3", "*", "2", "/", "1"})));
	}
	
	@Test
	public void test6666() {
		TwentyFourPoints tfp = new TwentyFourPoints();
		String[] result = tfp.find(6, 6, 6, 6);
		assertThat(result, is(new String[] {"6", "+", "6", "+", "6", "+", "6"}));
	}
	
	@Test
	public void test66126() {
		TwentyFourPoints tfp = new TwentyFourPoints();
		String[] result = tfp.find(6, 6, 18, 6);
		assertThat(result, anyOf(is(new String[] {"6", "+", "6", "+", "18", "-", "6"}), is(new String[] {"6", "+", "18", "-", "6", "+", "6"})));
	}
	
	@Test
	public void testTNoSolution() {
		TwentyFourPoints tfp = new TwentyFourPoints();
		String[] result = tfp.find(100, 200, 101, 201);
		assertThat(result, nullValue());
	}
	
	@Test
	public void test245204() {
		TwentyFourPoints tfp = new TwentyFourPoints();
		String[] result = tfp.find(24, 5, 20, 4);
		assertThat(result, is(new String[] {"4", "+", "20", "-", "5", "/", "24"}));
	}
}
