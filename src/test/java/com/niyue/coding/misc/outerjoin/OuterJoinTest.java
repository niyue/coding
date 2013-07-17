package com.niyue.coding.misc.outerjoin;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class OuterJoinTest {

	@Test
	public void testUnique1x1Unique() {
		OuterJoin join = new OuterJoin();
		List<List<Integer>> relationA = Arrays.asList(
				Arrays.asList(1, 2));
		List<List<Integer>> relationB = Arrays.asList(
				Arrays.asList(2, 3));
		List<List<Integer>> relation = join.hashJoin(relationA, relationB);
		assertThat(relation, is(Arrays.asList(Arrays.asList(1, 2, 3))));
	}
	
	@Test
	public void testUnique1x2NonUnique() {
		OuterJoin join = new OuterJoin();
		List<List<Integer>> relationA = Arrays.asList(
				Arrays.asList(1, 2));
		List<List<Integer>> relationB = Arrays.asList(
				Arrays.asList(2, 4),
				Arrays.asList(2, 3));
		List<List<Integer>> relation = join.hashJoin(relationA, relationB);
		assertThat(relation, is(Arrays.asList(
				Arrays.asList(1, 2, 4),
				Arrays.asList(1, 2, 3))));
	}
	
	@Test
	public void testUnique2x2NonUniqueLeftNonMatched() {
		OuterJoin join = new OuterJoin();
		List<List<Integer>> relationA = Arrays.asList(
				Arrays.asList(1, 2),
				Arrays.asList(1, 11));
		List<List<Integer>> relationB = Arrays.asList(
				Arrays.asList(2, 4),
				Arrays.asList(2, 3));
		List<List<Integer>> relation = join.hashJoin(relationA, relationB);
		assertThat(relation, is(Arrays.asList(
				Arrays.asList(1, 2, 4),
				Arrays.asList(1, 2, 3),
				Arrays.asList(1, 11, null))));
	}
	
	@Test
	public void testUnique2x3NonUniqueRightNonMatched() {
		OuterJoin join = new OuterJoin();
		List<List<Integer>> relationA = Arrays.asList(
				Arrays.asList(1, 2),
				Arrays.asList(1, 11));
		List<List<Integer>> relationB = Arrays.asList(
				Arrays.asList(2, 4),
				Arrays.asList(2, 3),
				Arrays.asList(13, 1));
		List<List<Integer>> relation = join.hashJoin(relationA, relationB);
		assertThat(relation, is(Arrays.asList(
				Arrays.asList(1, 2, 4),
				Arrays.asList(1, 2, 3),
				Arrays.asList(1, 11, null),
				Arrays.asList(null, 13, 1))));
	}
}
