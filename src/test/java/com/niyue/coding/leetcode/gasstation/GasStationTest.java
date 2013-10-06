package com.niyue.coding.leetcode.gasstation;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class GasStationTest {

	@Test
	public void testOneGasStation() {
		Solution sl = new Solution();
		int gasStation = sl.canCompleteCircuit(new int[] {1}, new int[]{1});
		assertThat(gasStation, is(0));
	}
	
	@Test
	public void testOneGasStationCannotComplete() {
		Solution sl = new Solution();
		int gasStation = sl.canCompleteCircuit(new int[] {1}, new int[]{2});
		assertThat(gasStation, is(-1));
	}

	@Test
	public void testTwoGasStations() {
		Solution sl = new Solution();
		int gasStation = sl.canCompleteCircuit(new int[] {1, 2}, new int[]{2, 1});
		assertThat(gasStation, is(1));
	}
}
