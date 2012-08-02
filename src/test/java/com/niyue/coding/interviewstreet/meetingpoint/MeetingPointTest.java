package com.niyue.coding.interviewstreet.meetingpoint;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeetingPointTest {

	@Test
	public void testSelectMinPoint() {
		Solution sl = new Solution();
		int min = sl.minPoint(new int[]{1, 2, 4});
		assertEquals(2, min);
	}
	
	@Test
	public void testSelectMinPointWithNegativeNumber() {
		Solution sl = new Solution();
		int min = sl.minPoint(new int[]{-1, -2, 4});
		assertEquals(-1, min);
	}
	
	@Test
	public void testSelectMinPointMultipleMinPoints() {
		Solution sl = new Solution();
		int min = sl.minPoint(new int[]{-2, -1, -3, 50, 10, 0});
		assertTrue(min == 0 || min == -1);
		assertEquals(-1, min); // the first one in sorted order will be used
	}
	
	@Test
	public void testNearestPoint() {
		Solution sl = new Solution();
		int[] nearestPoint = sl.nearestPoint(new int[]{1, 2, 4}, new int[]{1, 4, 3}, 2, 3);
		assertArrayEquals(new int[]{2, 4}, nearestPoint);
	}
}