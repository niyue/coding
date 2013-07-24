package com.niyue.coding.misc.missingchars;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class MissingCharsTest {

	@Test
	public void testOneElmentEmptyElement() {
		MissingChars mc = new MissingChars();
		List<Integer> missings = mc.find("1", "");
		assertThat(missings, is(Arrays.asList(0)));
	}
	
	@Test
	public void testTwpElmentEmptyElement() {
		MissingChars mc = new MissingChars();
		List<Integer> missings = mc.find("21", "");
		assertThat(missings, is(Arrays.asList(0, 1)));
	}
	
	@Test
	public void testOneElmentOneElement() {
		MissingChars mc = new MissingChars();
		List<Integer> missings = mc.find("1", "1");
		assertThat(missings, is(Collections.<Integer>emptyList()));
	}
	
	@Test
	public void testTwoElmentsOneElement() {
		MissingChars mc = new MissingChars();
		List<Integer> missings = mc.find("12", "1");
		assertThat(missings, is(Arrays.asList(1)));
	}
	
	@Test
	public void testMissingLastChar() {
		MissingChars mc = new MissingChars();
		List<Integer> missings = mc.find("abc", "ab");
		assertThat(missings, is(Arrays.asList(2)));
	}
	
	@Test
	public void testMissingMiddleChar() {
		MissingChars mc = new MissingChars();
		List<Integer> missings = mc.find("abc", "ac");
		assertThat(missings, is(Arrays.asList(1)));
	}
	
	@Test
	public void testMissingFirstAndLastChar() {
		MissingChars mc = new MissingChars();
		List<Integer> missings = mc.find("abc", "b");
		assertThat(missings, is(Arrays.asList(0, 2)));
	}
	
	@Test
	public void testMissingDuplicatedChar() {
		MissingChars mc = new MissingChars();
		List<Integer> missings = mc.find("aab", "ab");
		assertThat(missings, is(Arrays.asList(1)));
	}
}
