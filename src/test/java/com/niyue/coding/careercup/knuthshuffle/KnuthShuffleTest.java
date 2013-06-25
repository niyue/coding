package com.niyue.coding.careercup.knuthshuffle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class KnuthShuffleTest {

	@Test
	public void testShuffle() {
		KnuthShuffle knuth = new KnuthShuffle();
		int[][] counts = new int[5][5];
		for(int i = 0; i < 1000; i++) {
			int[] shuffled = knuth.shuffle(new int[] {1, 2, 3, 4, 5});
			assertThat(shuffled.length, is(5));
			for(int j = 0; j < 5; j++) {
				counts[j][shuffled[j] - 1]++;
			}
		}
		System.out.println(Arrays.deepToString(counts));
	}
}
