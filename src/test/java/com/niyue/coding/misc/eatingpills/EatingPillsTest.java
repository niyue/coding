package com.niyue.coding.misc.eatingpills;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

import org.junit.Test;

public class EatingPillsTest {

	@Test
	public void testOnePillWithOnePillLeft() {
		EatingPills ep = new EatingPills();
		double p = ep.possibility(1, 1, 0);
		assertThat(p, closeTo(1, 0.001));
	}
	
	@Test
	public void testOnePillWithOneHalfLeft() {
		EatingPills ep = new EatingPills();
		double p = ep.possibility(1, 0, 1);
		assertThat(p, closeTo(1, 0.001));
	}
	
	@Test
	public void testOnePillWithNoneLeft() {
		EatingPills ep = new EatingPills();
		double p = ep.possibility(1, 0, 0);
		assertThat(p, closeTo(1, 0.001));
	}
	
	@Test
	public void testTwoPillsWithOnePillAndAHalfLeft() {
		EatingPills ep = new EatingPills();
		double p = ep.possibility(2, 1, 1);
		assertThat(p, closeTo(1, 0.001));
	}
	
	@Test
	public void testTwoPillsWithOnePillLeft() {
		EatingPills ep = new EatingPills();
		double p = ep.possibility(2, 1, 0);
		assertThat(p, closeTo(0.5, 0.001));
	}
	
	@Test
	public void testTwoPillsWithHalfPillLeft() {
		EatingPills ep = new EatingPills();
		double p = ep.possibility(2, 0, 1);
		assertThat(p, closeTo(1, 0.001));
	}

}
