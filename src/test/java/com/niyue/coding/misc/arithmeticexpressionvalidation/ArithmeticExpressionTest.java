package com.niyue.coding.misc.arithmeticexpressionvalidation;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ArithmeticExpressionTest {

	@Test
	public void test1Plus1() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		int result = exp.eval("1 + 1");
		assertThat(result, is(2));
	}
	
	@Test
	public void test2Multiply2() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		int result = exp.eval("2 * 2");
		assertThat(result, is(4));
	}
	
	@Test
	public void test2Multiply2Plus1() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		int result = exp.eval("2 * 2 + 1");
		assertThat(result, is(5));
	}
	
	@Test
	public void test2Plus3Multiply2() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		int result = exp.eval("2 + 3 * 2");
		assertThat(result, is(8));
	}
	
	@Test
	public void test1Plus1WithParenthesis() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		int result = exp.eval("( 1 + 1 )");
		assertThat(result, is(2));
	}
	
	@Test
	public void test2Multiply2Plus1WithParenthesis() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		int result = exp.eval("2 * ( 2 + 1 )");
		assertThat(result, is(6));
	}
	
	@Test
	public void test2Plus3Multiply2WithParenthesis() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		int result = exp.eval("( 2 + 3 ) * 2");
		assertThat(result, is(10));
	}
	
	@Test
	public void testDoubleParenthesis() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		int result = exp.eval("( 2 + 3 ) * ( 2 + 4 )");
		assertThat(result, is(30));
	}
	
	@Test
	public void testPlusMultiplyParenthesis() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		int result = exp.eval("2 + 3 * ( 2 + 4 )");
		assertThat(result, is(20));
	}
	
	@Test
	public void testDivisionPlusMultiplyParenthesis() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		int result = exp.eval("2 / 3 * ( 2 + 4 )");
		assertThat(result, is(0));
	}
	
	@Test
	public void testSubstractionPlusMultiplyParenthesis() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		int result = exp.eval("2 * 3 + ( 2 - 4 )");
		assertThat(result, is(4));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUnclosedParenthesis() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		exp.eval("2 * 3 + ( ( 2 - 4 )");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMultipleClosedParenthesis() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		exp.eval("2 * ) 2 - 4 )");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMultipleOperands() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		exp.eval("2 * 2 3 - 4 )");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSingleOperand() {
		ArithmeticExpressionValidation exp = new ArithmeticExpressionValidation();
		exp.eval("- 4 )");
	}

}
