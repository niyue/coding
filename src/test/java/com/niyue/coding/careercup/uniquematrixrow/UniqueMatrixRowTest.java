package com.niyue.coding.careercup.uniquematrixrow;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class UniqueMatrixRowTest {

	@Test
	public void testSample() {
		UniqueMatrixRow umr = new UniqueMatrixRow();
		int[][] uniqueRows = umr.findUnique(new int[][] {
			new int[] {0, 1, 0, 0, 1},
			new int[] {1, 0, 1, 1, 0},
			new int[] {0, 1, 0, 0, 1},
			new int[] {1, 1, 1, 0, 0}
		});
		
		assertThat(uniqueRows, is(new int[][] {
				new int[] {0, 1, 0, 0, 1},
				new int[] {1, 0, 1, 1, 0},
				new int[] {1, 1, 1, 0, 0}
		}));
	}
}
