package com.niyue.coding.careercup.josephusproblem;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class JosephusProblemTest {

	@Test
	public void testOnePersonInTwo() {
		JosephusProblem jp = new JosephusProblem();
		int pos = jp.last(1, 2);
		assertThat(pos, is(0));
	}
	
	@Test
	public void testTwoPersonsInTwo() {
		JosephusProblem jp = new JosephusProblem();
		int pos = jp.last(2, 2);
		assertThat(pos, is(0));
	}
	
	@Test
	public void testThreePersonsInTwo() {
		JosephusProblem jp = new JosephusProblem();
		int pos = jp.last(3, 2);
		assertThat(pos, is(2));
	}

}
