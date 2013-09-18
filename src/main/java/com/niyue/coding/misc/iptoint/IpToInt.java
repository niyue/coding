package com.niyue.coding.misc.iptoint;

public class IpToInt {
	public int convert(String ipString) {
		String[] segments = ipString.split("\\.");
		int ip = 0;
		for (String segment : segments) {
			ip <<= 8;
			ip |= Integer.valueOf(segment);
		}
		return ip;
	}
}
