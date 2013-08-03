package com.niyue.coding.careercup.tripletimes;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class TripleTimesTest {

	@Test
	public void test1112() {
		TripleTimes tt = new TripleTimes();
		int x = tt.find(new int[] {1, 1, 1, 2});
		assertThat(x, is(2));
	}
	
	@Test
	public void testComplex() {
		TripleTimes tt = new TripleTimes();
		int x = tt.find(new int[] {712,88,9,33,33,88,712,9,9,88,33,712,2000000000});
		assertThat(x, is(2000000000));
	}
	
	@Test
	public void testContinousTripleWithSingleInMiddle() {
		TripleTimes tt = new TripleTimes();
		int x = tt.find(new int[] {1,1,1,3,3,3,20,4,4,4});
		assertThat(x, is(20));
	}
	
	@Test
	public void testSingleInMiddle() {
		TripleTimes tt = new TripleTimes();
		int x = tt.find(new int[] {1, 1, 20, 3, 3, 20, 20, 15, 4, 1, 4, 3, 4});
		assertThat(x, is(15));
	}

}
