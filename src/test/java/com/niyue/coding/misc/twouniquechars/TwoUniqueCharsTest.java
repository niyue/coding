package com.niyue.coding.misc.twouniquechars;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TwoUniqueCharsTest {
	@Test
	public void testEmptyString() {
		TwoUniqueChars uc = new TwoUniqueChars();
		String longest = uc.find("");
		assertThat(longest, is(""));
	}
	
	@Test
	public void testSingleChar() {
		TwoUniqueChars uc = new TwoUniqueChars();
		String longest = uc.find("a");
		assertThat(longest, is("a"));
	}
	
	@Test
	public void testTwoDifferentChars() {
		TwoUniqueChars uc = new TwoUniqueChars();
		String longest = uc.find("ab");
		assertThat(longest, is("ab"));
	}
	
	@Test
	public void testTwoSameChars() {
		TwoUniqueChars uc = new TwoUniqueChars();
		String longest = uc.find("aa");
		assertThat(longest, is("aa"));
	}
	
	@Test
	public void testThreeSameChars() {
		TwoUniqueChars uc = new TwoUniqueChars();
		String longest = uc.find("aaa");
		assertThat(longest, is("aaa"));
	}
	
	@Test
	public void testThreeDifferentChars() {
		TwoUniqueChars uc = new TwoUniqueChars();
		String longest = uc.find("abc");
		assertThat(longest, is("ab"));
	}
	
	@Test
	public void testThreeCharsOnlyTwoUnique() {
		TwoUniqueChars uc = new TwoUniqueChars();
		String longest = uc.find("cbb");
		assertThat(longest, is("cbb"));
	}
	
	@Test
	public void testTrailingLongest() {
		TwoUniqueChars uc = new TwoUniqueChars();
		String longest = uc.find("acbb");
		assertThat(longest, is("cbb"));
	}
	
	@Test
	public void testThirdCharComesIn() {
		TwoUniqueChars uc = new TwoUniqueChars();
		String longest = uc.find("haaba");
		assertThat(longest, is("aaba"));
	}
	
	@Test
	public void testLong() {
		TwoUniqueChars uc = new TwoUniqueChars();
		String longest = uc.find("aabadefghaabbaagad");
		assertThat(longest, is("aabbaa"));
	}
}
