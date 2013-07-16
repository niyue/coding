package com.niyue.coding.misc.continouschars;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ContinousCharsTest {

	@Test
	public void testSingleChar() {
		ContinousChars cc = new ContinousChars();
		List<Character> chars = cc.find("i");
		assertThat(chars, is(Arrays.asList('i')));
	}
	
	@Test
	public void testTwoDifferentChars() {
		ContinousChars cc = new ContinousChars();
		List<Character> chars = cc.find("ij");
		assertThat(chars, is(Arrays.asList('i', 'j')));
	}
	
	@Test
	public void testTwoCharsWithDifferentCount() {
		ContinousChars cc = new ContinousChars();
		List<Character> chars = cc.find("ijj");
		assertThat(chars, is(Arrays.asList('j')));
	}
	
	@Test
	public void testTwoNonContinousCharsWithDifferentCount() {
		ContinousChars cc = new ContinousChars();
		List<Character> chars = cc.find("jij");
		assertThat(chars, is(Arrays.asList('j', 'i')));
	}
	
	@Test
	public void testMultipleSameCount() {
		ContinousChars cc = new ContinousChars();
		List<Character> chars = cc.find("thiis iss a senntencee");
		assertThat(chars, is(Arrays.asList('i', 's', 'n', 'e')));
	}
	
	@Test
	public void testThreeCount() {
		ContinousChars cc = new ContinousChars();
		List<Character> chars = cc.find("thiisss iss a senntttenceee");
		assertThat(chars, is(Arrays.asList('s', 't', 'e')));
	}
	
	@Test
	public void testFourCount() {
		ContinousChars cc = new ContinousChars();
		List<Character> chars = cc.find("thiisss iss a sennnntttenceee");
		assertThat(chars, is(Arrays.asList('n')));
	}
}
