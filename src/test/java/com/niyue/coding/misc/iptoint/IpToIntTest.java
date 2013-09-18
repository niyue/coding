package com.niyue.coding.misc.iptoint;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class IpToIntTest {

	@Test
	public void testIpToInt() {
		IpToInt iti = new IpToInt();
		int ip = iti.convert("255.255.255.0");
		assertThat(ip, is(0xffffff00));
	}
	
	@Test
	public void testIpToIntLeadingZero() {
		IpToInt iti = new IpToInt();
		int ip = iti.convert("0.255.255.1");
		assertThat(ip, is(0x00ffff01));
	}
	
	@Test
	public void testNon255InMiddle() {
		IpToInt iti = new IpToInt();
		int ip = iti.convert("0.16.255.1");
		assertThat(ip, is(0x0010ff01));
	}

}
