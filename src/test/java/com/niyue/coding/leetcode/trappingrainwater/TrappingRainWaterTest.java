package com.niyue.coding.leetcode.trappingrainwater;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrappingRainWaterTest {

	@Test
	// the problem was not clearly understood at first, confused it with another similar problem
	public void testLong() {
		Solution sl = new Solution();
		int water = sl.trap(new int[]{5,5,1,7,1,1,5,2,7,6});
		assertEquals(23, water);
	}
}
