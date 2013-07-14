package com.niyue.coding.misc.numberformat;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class NumberFormatTest {

	@Test
	public void test1() {
		NumberFormat nf = new NumberFormat();
		String format = nf.convert(1);
		assertThat(format, is("+1 * 1 * 2^0"));
	}
	
	@Test
	public void test2() {
		NumberFormat nf = new NumberFormat();
		String format = nf.convert(2);
		assertThat(format, is("+1 * 1 * 2^1"));
	}
	
	@Test
	public void test4() {
		NumberFormat nf = new NumberFormat();
		String format = nf.convert(4);
		assertThat(format, is("+1 * 1 * 2^2"));
	}
	
	@Test
	public void test7() {
		NumberFormat nf = new NumberFormat();
		String format = nf.convert(7);
		assertThat(format, is("+1 * 7 * 2^0"));
	}
	
	@Test
	public void testMinus2() {
		NumberFormat nf = new NumberFormat();
		String format = nf.convert(-2);
		assertThat(format, is("(-1) * 1 * 2^1"));
	}

}
