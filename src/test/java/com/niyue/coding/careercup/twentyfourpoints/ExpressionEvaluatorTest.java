package com.niyue.coding.careercup.twentyfourpoints;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ExpressionEvaluatorTest {

	@Test
	public void testAddition() {
		ExpressionEvaluator ee = new ExpressionEvaluator();
		int result = ee.evaluate(new String[] {"0", "+", "1"});
		assertThat(result, is(1));
	}
	
	@Test
	public void testDivision() {
		ExpressionEvaluator ee = new ExpressionEvaluator();
		int result = ee.evaluate(new String[] {"0", "/", "1"});
		assertThat(result, is(0));
	}
	
	@Test
	public void testSubstraction() {
		ExpressionEvaluator ee = new ExpressionEvaluator();
		int result = ee.evaluate(new String[] {"0", "-", "1"});
		assertThat(result, is(-1));
	}
	
	@Test
	public void testAdditionAndSubstraction() {
		ExpressionEvaluator ee = new ExpressionEvaluator();
		int result = ee.evaluate(new String[] {"0", "+", "1", "-", "3"});
		assertThat(result, is(-2));
	}
	
	@Test
	public void testAdditionAndMultiplication() {
		ExpressionEvaluator ee = new ExpressionEvaluator();
		int result = ee.evaluate(new String[] {"1", "+", "1", "*", "3"});
		assertThat(result, is(4));
	}
	
	@Test
	public void testMultiplicationAndMultiplication() {
		ExpressionEvaluator ee = new ExpressionEvaluator();
		int result = ee.evaluate(new String[] {"2", "*", "2", "*", "3"});
		assertThat(result, is(12));
	}
}
