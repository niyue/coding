package com.niyue.coding.misc.robotwalk;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

import org.junit.Test;

import com.niyue.coding.misc.RobotWalk.RobotWalk;

public class RobotWalkTest {

	@Test
	public void test0() {
		RobotWalk walk = new RobotWalk();
		double possibility = walk.calc(0);
		assertThat(possibility, closeTo(1, 0.0001));
	}
	
	@Test
	public void test1() {
		RobotWalk walk = new RobotWalk();
		double possibility = walk.calc(1);
		assertThat(possibility, closeTo(0, 0.0001));
	}
	
	@Test
	public void test2() {
		RobotWalk walk = new RobotWalk();
		double possibility = walk.calc(2);
		assertThat(possibility, closeTo(0.5, 0.0001));
	}
	
	@Test
	public void test3() {
		RobotWalk walk = new RobotWalk();
		double possibility = walk.calc(3);
		assertThat(possibility, closeTo(0, 0.0001));
	}
	
	@Test
	public void test4() {
		RobotWalk walk = new RobotWalk();
		double possibility = walk.calc(4);
		assertThat(possibility, closeTo(0.375, 0.0001));
	}
}
