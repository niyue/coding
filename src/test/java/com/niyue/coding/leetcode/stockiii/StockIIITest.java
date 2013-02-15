package com.niyue.coding.leetcode.stockiii;

import static org.junit.Assert.*;

import org.junit.Test;

public class StockIIITest {

	@Test
	public void testSimplePrices() {
		Solution sl = new Solution();
		int maxProfit = sl.maxProfit(new int[] {1, 2});
		assertEquals(1, maxProfit);
	}
}
