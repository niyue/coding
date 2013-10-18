package com.niyue.coding.leetcode.stockiii;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class StockIIITest {

	@Test
	public void testSimplePrices() {
		Solution sl = new Solution();
		int maxProfit = sl.maxProfit(new int[] {1, 2});
		assertThat(maxProfit, is(1));
	}
	
	@Test
	public void testTwoTransactions() {
		Solution sl = new Solution();
		int maxProfit = sl.maxProfit(new int[] {1, 2, 1, 3});
		assertThat(maxProfit, is(3));
	}
	
	@Test
	public void testDownUpDownTransactions() {
		Solution sl = new Solution();
		int maxProfit = sl.maxProfit(new int[] {2, 1, 2, 1, 0, 1});
		assertThat(maxProfit, is(2));
	}
}
