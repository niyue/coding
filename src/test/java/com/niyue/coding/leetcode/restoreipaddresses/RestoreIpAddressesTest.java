package com.niyue.coding.leetcode.restoreipaddresses;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class RestoreIpAddressesTest {

	@Test
	// restore index is not correctly decreased
	public void testAllZeroIp() {
		Solution sl = new Solution();
		List<String> ipList = sl.restoreIpAddresses("0000");
		assertEquals(1, ipList.size());
		assertEquals("0.0.0.0", ipList.get(0));
	}
	
	@Test
	// leading zero segment validity checking is not implemented correctly
	public void testAllOneIp() {
		Solution sl = new Solution();
		List<String> ipList = sl.restoreIpAddresses("1111");
		assertEquals(1, ipList.size());
		assertEquals("1.1.1.1", ipList.get(0));
	}
	
	@Test
	// char to int in segment validitiy checking is not implemented correctly
	// should be segment = segment * 10 + ip[i] instead of segment += segment * 10 + ip[i];
	public void testAll255Ip() {
		Solution sl = new Solution();
		List<String> ipList = sl.restoreIpAddresses("255255255255");
		assertEquals(1, ipList.size());
		assertEquals("255.255.255.255", ipList.get(0));
	}
}
