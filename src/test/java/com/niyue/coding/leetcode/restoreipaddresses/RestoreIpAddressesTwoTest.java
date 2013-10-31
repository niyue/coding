package com.niyue.coding.leetcode.restoreipaddresses;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class RestoreIpAddressesTwoTest {

	@Test
	public void testAllZeroIp() {
		SolutionTwo sl = new SolutionTwo();
		List<String> ipList = sl.restoreIpAddresses("0000");
		assertEquals(1, ipList.size());
		assertEquals("0.0.0.0", ipList.get(0));
	}
	
	@Test
	public void testAllOneIp() {
		SolutionTwo sl = new SolutionTwo();
		List<String> ipList = sl.restoreIpAddresses("1111");
		assertEquals(1, ipList.size());
		assertEquals("1.1.1.1", ipList.get(0));
	}
	
	@Test
	public void testAll255Ip() {
		SolutionTwo sl = new SolutionTwo();
		List<String> ipList = sl.restoreIpAddresses("255255255255");
		assertEquals(1, ipList.size());
		assertEquals("255.255.255.255", ipList.get(0));
	}
	
	@Test
	public void testLeadingZero() {
		SolutionTwo sl = new SolutionTwo();
		List<String> ipList = sl.restoreIpAddresses("010010");
		assertEquals(2, ipList.size());
	}
}
