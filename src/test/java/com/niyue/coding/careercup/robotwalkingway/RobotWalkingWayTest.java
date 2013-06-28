package com.niyue.coding.careercup.robotwalkingway;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class RobotWalkingWayTest {

	@Test
	public void test1x1() {
		RobotWalkingWay rww = new RobotWalkingWay();
		int count = rww.numberOfWays(1, 1);
		assertThat(count, is(1));
	}
	
	@Test
	public void test2x1() {
		RobotWalkingWay rww = new RobotWalkingWay();
		int count = rww.numberOfWays(2, 1);
		assertThat(count, is(1));
	}
	
	@Test
	public void test2x2() {
		RobotWalkingWay rww = new RobotWalkingWay();
		int count = rww.numberOfWays(2, 2);
		assertThat(count, is(2));
	}
	
	@Test
	public void test3x2() {
		RobotWalkingWay rww = new RobotWalkingWay();
		int count = rww.numberOfWays(3, 2);
		assertThat(count, is(3));
	}
	
	@Test
	public void test3x3() {
		RobotWalkingWay rww = new RobotWalkingWay();
		int count = rww.numberOfWays(3, 3);
		assertThat(count, is(6));
	}
}
