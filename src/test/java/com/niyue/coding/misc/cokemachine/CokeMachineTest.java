package com.niyue.coding.misc.cokemachine;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class CokeMachineTest {

	@Test
	public void testOneMachine() {
		CokeMachine coke = new CokeMachine();
		boolean fillable = coke.fillable(50, 100, new int[] {60, 90});
		assertThat(fillable, is(true));
	}
	
	@Test
	public void testOneMachineNotFillable() {
		CokeMachine coke = new CokeMachine();
		boolean fillable = coke.fillable(50, 80, new int[] {60, 90});
		assertThat(fillable, is(false));
	}
	
	@Test
	public void testTwoMachines() {
		CokeMachine coke = new CokeMachine();
		boolean fillable = coke.fillable(110, 140, new int[] {60, 80, 50, 51});
		assertThat(fillable, is(true));
	}
	
	@Test
	public void testTwoMachinesThreeFillsNeeded() {
		CokeMachine coke = new CokeMachine();
		boolean fillable = coke.fillable(120, 140, new int[] {60, 80, 50, 51});
		assertThat(fillable, is(false));
	}

	@Test
	public void testTwoMachinesNotFillable() {
		CokeMachine coke = new CokeMachine();
		boolean fillable = coke.fillable(120, 130, new int[] {60, 80, 50, 51});
		assertThat(fillable, is(false));
	}
	
	@Test
	public void testThreeMachines() {
		CokeMachine coke = new CokeMachine();
		boolean fillable = coke.fillable(119, 152, new int[] {60, 80, 50, 51, 70, 100});
		assertThat(fillable, is(true));
	}
}
