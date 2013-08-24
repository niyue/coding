package com.niyue.coding.misc.integersearchinstring;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerSearchInStringTest {

	@Test
	public void testSingleCharString() {
		IntegerSearchInString isis = new IntegerSearchInString();
		boolean existed = isis.isExisted("1", 1);
		assertThat(existed, is(true));
	}
	
	@Test
	public void testSingleCharStringNotExist() {
		IntegerSearchInString isis = new IntegerSearchInString();
		boolean existed = isis.isExisted("2", 1);
		assertThat(existed, is(false));
	}

	@Test
	public void testTwoSingleDigitNumbersInString() {
		IntegerSearchInString isis = new IntegerSearchInString();
		boolean existed = isis.isExisted("1 2", 1);
		assertThat(existed, is(true));
	}
	
	@Test
	public void testTwoSingleDigitNumbersInStringNotExist() {
		IntegerSearchInString isis = new IntegerSearchInString();
		boolean existed = isis.isExisted("1 2", 3);
		assertThat(existed, is(false));
	}
	
	@Test
	public void testTwoMultipleDigitsNumbersInString() {
		IntegerSearchInString isis = new IntegerSearchInString();
		boolean existed = isis.isExisted("12 23", 23);
		assertThat(existed, is(true));
	}
	
	@Test
	public void testThreeMultipleDigitsNumbersInString() {
		IntegerSearchInString isis = new IntegerSearchInString();
		boolean existed = isis.isExisted("12 223 583", 223);
		assertThat(existed, is(true));
	}
	
	@Test
	public void testSingleDigitAsPartOfTwoDigitsNumber() {
		IntegerSearchInString isis = new IntegerSearchInString();
		boolean existed = isis.isExisted("12 23", 2);
		assertThat(existed, is(false));
	}
	
	@Test
	public void testLongNumbers() {
		IntegerSearchInString isis = new IntegerSearchInString();
		boolean existed = isis.isExisted("1 52 69 456789 994546566", 69);
		assertThat(existed, is(true));
	}
}
