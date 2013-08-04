package com.niyue.coding.misc.twentysixeexpbase;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import com.niyue.coding.misc.twentysixexpbase.TwentySixExpBase;

public class TwentySixExpBaseTest {

	@Test
	public void testZero() {
		TwentySixExpBase converter = new TwentySixExpBase();
		String result = converter.convert(0);
		assertThat(result, is("a"));
	}
	
	@Test
	public void testOne() {
		TwentySixExpBase converter = new TwentySixExpBase();
		String result = converter.convert(1);
		assertThat(result, is("b"));
	}
	
	@Test
	public void test25() {
		TwentySixExpBase converter = new TwentySixExpBase();
		String result = converter.convert(25);
		assertThat(result, is("z"));
	}
	
	@Test
	public void test26() {
		TwentySixExpBase converter = new TwentySixExpBase();
		String result = converter.convert(26);
		assertThat(result, is("aa"));
	}
	
	@Test
	public void test27() {
		TwentySixExpBase converter = new TwentySixExpBase();
		String result = converter.convert(27);
		assertThat(result, is("ab"));
	}
	
	@Test
	public void test52() {
		TwentySixExpBase converter = new TwentySixExpBase();
		String result = converter.convert(52);
		assertThat(result, is("ba"));
	}
	
	@Test
	public void test26x27() {
		TwentySixExpBase converter = new TwentySixExpBase();
		String result = converter.convert(26 + 26 * 26);
		assertThat(result, is("aaa"));
	}
	
	@Test
	public void testFourA() {
		TwentySixExpBase converter = new TwentySixExpBase();
		String result = converter.convert(26 + 26 * 26 + 26 * 26 * 26);
		assertThat(result, is("aaaa"));
	}

}
