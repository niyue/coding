package com.niyue.coding.leetcode.validnumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidNumberTest {

	@Test
	public void testNumberWithF() {
		Solution sl = new Solution();
		boolean isNumber = sl.isNumber("959440.94f");
		assertFalse(isNumber);
	}
	
	@Test
	public void testNumberWithD() {
		Solution sl = new Solution();
		boolean isNumber = sl.isNumber("84656e656D");
		assertFalse(isNumber);
	}
}
