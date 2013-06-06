package com.niyue.coding.careercup.propotionalrandomness;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import java.util.Arrays;

import org.junit.Test;

public class PropotionalRandomnessTest {

	@Test
	public void testRandom() {
		PropotionalRandomness random = new PropotionalRandomness();
		// int[] count = new int[5];
		for(int i = 0; i < 10000; i++) {
			int index = random.select(new int[]{2, 3, 1, 2, 4});
			assertThat(Arrays.asList(0, 1, 2, 3, 4), hasItem(index));
			// count[index]++;
		}
//		for(int i : count) {
//			System.out.println(i);
//		}
	}
}
