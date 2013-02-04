package com.niyue.coding.leetcode.trianglesum;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.google.common.collect.Lists;

@SuppressWarnings({ "serial" })
public class TriangleSumTest {
	@Test
	public void testOneRow() throws Exception {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>() {{
			add(Lists.newArrayList(-10));
		}};
		Solution sl = new Solution();
		int min = sl.minimumTotal(triangle);
		assertEquals(-10, min);
	}
	
	@Test
	public void testTwoRows() throws Exception {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>() {{
			add(Lists.newArrayList(1));
			add(Lists.newArrayList(2, 3));
		}};
		Solution sl = new Solution();
		int min = sl.minimumTotal(triangle);
		assertEquals(3, min);
	}
}
