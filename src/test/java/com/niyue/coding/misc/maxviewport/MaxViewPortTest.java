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

}
