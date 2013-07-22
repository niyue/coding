package com.niyue.coding.careercup.phonenumbergrouper;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PhoneNumberGrouperTest {

	@Test
	public void testTwoDigitsNumber() {
		PhoneNumberGrouper grouper = new PhoneNumberGrouper();
		List<String> groups = grouper.group("11");
		assertThat(groups, is(Arrays.asList("11")));
	}
	
	@Test
	public void testThreeDigitsNumber() {
		PhoneNumberGrouper grouper = new PhoneNumberGrouper();
		List<String> groups = grouper.group("112");
		assertThat(groups, is(Arrays.asList("112")));
	}
	
	@Test
	public void testFourDigitsNumber() {
		PhoneNumberGrouper grouper = new PhoneNumberGrouper();
		List<String> groups = grouper.group("1122");
		assertThat(groups, is(Arrays.asList("11", "22")));
	}
	
	@Test
	public void testFiveDigitsNumber() {
		PhoneNumberGrouper grouper = new PhoneNumberGrouper();
		List<String> groups = grouper.group("11322");
		assertThat(groups, is(Arrays.asList("113", "22")));
	}
	
	@Test
	public void testSixDigitsNumber() {
		PhoneNumberGrouper grouper = new PhoneNumberGrouper();
		List<String> groups = grouper.group("113322");
		assertThat(groups, is(Arrays.asList("11", "33", "22")));
	}
	
	@Test
	public void testThreeSameDigitsFiveDigitsNumber() {
		PhoneNumberGrouper grouper = new PhoneNumberGrouper();
		List<String> groups = grouper.group("11222");
		assertThat(groups, is(Arrays.asList("11", "222")));
	}
	
	@Test
	public void testAllDistinctDigits() {
		PhoneNumberGrouper grouper = new PhoneNumberGrouper();
		List<String> groups = grouper.group("123456");
		assertThat(groups, is(Arrays.asList("12", "34", "56")));
	}
}
