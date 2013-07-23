package com.niyue.coding.misc.majorityvote;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class MajorityVoteTest {

	@Test
	public void testOneElement() {
		MajorityVote vote = new MajorityVote();
		Integer majority = vote.find(new int[] {1});
		assertThat(majority, is(1));
	}
	
	@Test
	public void testTwoElements() {
		MajorityVote vote = new MajorityVote();
		Integer majority = vote.find(new int[] {2, 1});
		assertThat(majority, is(2));
	}
	
	@Test
	public void testThreeElementsWithTwoTheSame() {
		MajorityVote vote = new MajorityVote();
		Integer majority = vote.find(new int[] {2, 1, 2});
		assertThat(majority, is(2));
	}
	
	@Test
	public void testThreeElementsWithAllDifferent() {
		MajorityVote vote = new MajorityVote();
		Integer majority = vote.find(new int[] {2, 1, 3});
		assertThat(majority, nullValue());
	}
	
	@Test
	public void testFourElementsWithTwoTheSame() {
		MajorityVote vote = new MajorityVote();
		Integer majority = vote.find(new int[] {1, 2, 2, 3});
		assertThat(majority, is(2));
	}
}

