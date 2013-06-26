package com.niyue.coding.careercup.knuthshuffle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class OnlineKnuthShuffleTest {

	@Test
	public void testShuffle() {
		OnlineKnuthShuffle knuth = new OnlineKnuthShuffle();
		int[][] counts = new int[5][5];
		for(int i = 0; i < 1000; i++) {
			List<Integer> shuffled = knuth.shuffle(Arrays.asList(1, 2, 3, 4, 5).iterator());
			assertThat(shuffled.size(), is(5));
			for(int j = 0; j < 5; j++) {
				counts[j][shuffled.get(j) - 1]++;
			}
		}
		System.out.println(Arrays.deepToString(counts));
	}
}
