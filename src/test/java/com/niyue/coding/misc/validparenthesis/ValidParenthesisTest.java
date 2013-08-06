package com.niyue.coding.misc.validparenthesis;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ValidParenthesisTest {

	@Test
	public void testEmptyString() {
		ValidParenthesis vp = new ValidParenthesis();
		boolean isValid = vp.isValid("");
		assertThat(isValid, is(true));
	}
	
	@Test
	public void testOneCharString() {
		ValidParenthesis vp = new ValidParenthesis();
		boolean isValid = vp.isValid("a");
		assertThat(isValid, is(true));
	}
	
	@Test
	public void testOnePairParenthesis() {
		ValidParenthesis vp = new ValidParenthesis();
		boolean isValid = vp.isValid("(a)");
		assertThat(isValid, is(true));
	}
	
	@Test
	public void testUnevenOnePairParenthesis() {
		ValidParenthesis vp = new ValidParenthesis();
		boolean isValid = vp.isValid(")a(");
		assertThat(isValid, is(false));
	}
	
	@Test
	public void testComplexParenthesis() {
		ValidParenthesis vp = new ValidParenthesis();
		boolean isValid = vp.isValid("(ab)(e)");
		assertThat(isValid, is(true));
	}
	
	@Test
	public void testInvalidComplexParenthesis() {
		ValidParenthesis vp = new ValidParenthesis();
		boolean isValid = vp.isValid("(ab)()e)");
		assertThat(isValid, is(false));
	}

}
