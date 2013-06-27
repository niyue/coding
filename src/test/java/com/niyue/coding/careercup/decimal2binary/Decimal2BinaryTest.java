package com.niyue.coding.careercup.decimal2binary;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Decimal2BinaryTest {

	@Test
	public void testConvertSingleDigitInteger() {
		Decimal2Binary d2b = new Decimal2Binary();
		String binary = d2b.convert(1);
		assertThat(binary, is("1"));
	}
	
	@Test
	public void testConvertZero() {
		Decimal2Binary d2b = new Decimal2Binary();
		String binary = d2b.convert(0);
		assertThat(binary, is("0"));
	}
	
	@Test
	public void testConvertSmallInteger() {
		Decimal2Binary d2b = new Decimal2Binary();
		String binary = d2b.convert(4);
		assertThat(binary, is("100"));
	}
	
	@Test
	public void testConvertDoubleDecimalDigitsInteger() {
		Decimal2Binary d2b = new Decimal2Binary();
		String binary = d2b.convert(20);
		assertThat(binary, is("10100"));
	}

	@Test
	public void testConvertShortFloat() {
		Decimal2Binary d2b = new Decimal2Binary();
		String binary = d2b.convert(1.0f);
		assertThat(binary, is("1"));
	}
	
	@Test
	public void testConvertFloat() {
		Decimal2Binary d2b = new Decimal2Binary();
		String binary = d2b.convert(1.5f);
		assertThat(binary, is("1.1"));
	}
	
	@Test
	public void testConvert05() {
		Decimal2Binary d2b = new Decimal2Binary();
		String binary = d2b.convert(0.5f);
		assertThat(binary, is("0.1"));
	}
	
	@Test
	public void testConvertComplexFloat() {
		Decimal2Binary d2b = new Decimal2Binary();
		String binary = d2b.convert(1.625f);
		assertThat(binary, is("1.101"));
	}
	
	@Test
	public void testConvert() {
		Decimal2Binary d2b = new Decimal2Binary();
		String binary = d2b.convert(1.1f);
		assertThat(binary, is("1.00011001100110011001101"));
	}
}
