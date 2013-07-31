package com.niyue.coding.misc.maxviewport;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MaxViewPortTest {

	@Test
	public void testSinglePoint() {
		MaxViewPort viewPort = new MaxViewPort();
		int max = viewPort.count(new double[] {0.5}, 0.1);
		assertThat(max, is(1));
	}
	
	@Test
	public void testTwoPoints() {
		MaxViewPort viewPort = new MaxViewPort();
		int max = viewPort.count(new double[] {0.5, 0.6}, 0.1);
		assertThat(max, is(2));
	}
	
	@Test
	public void testThreePoints() {
		MaxViewPort viewPort = new MaxViewPort();
		int max = viewPort.count(new double[] {0.5, 0.55, 0.6}, 0.1);
		assertThat(max, is(3));
	}
	
	@Test
	public void testFourPoints() {
		MaxViewPort viewPort = new MaxViewPort();
		int max = viewPort.count(new double[] {0.1, 0.5, 0.55, 0.6, 1.1}, 0.1);
		assertThat(max, is(3));
	}
	
	@Test
	public void testMultiplePoints() {
		MaxViewPort viewPort = new MaxViewPort();
		int max = viewPort.count(new double[] {0.1, 0.5, 0.55, 0.6, 1.1, 1.9, 2.0, 2.01, 2.02, 2.03, 2.04, 3}, 0.1);
		assertThat(max, is(5));
	}
	
	@Test
	public void testOverlappedPoints() {
		MaxViewPort viewPort = new MaxViewPort();
		int max = viewPort.count(new double[] {0.01, 0.02, 0.5, 0.55, 0.6, Math.PI * 2 - 0.01, Math.PI * 2 - 0.02}, 0.1);
		assertThat(max, is(4));
	}

}
