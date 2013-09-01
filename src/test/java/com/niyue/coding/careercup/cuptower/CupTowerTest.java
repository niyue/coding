package com.niyue.coding.careercup.cuptower;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.niyue.coding.careercup.glassestower.CupTower;

public class CupTowerTest {

	@Test
	public void testOneCup() {
		CupTower ct = new CupTower();
		double amount = ct.liquidPoured(2, 0, 0);
		assertThat(amount, closeTo(1.0, 0.001));
	}
	
	@Test
	public void testTwoLayersOfCup() {
		CupTower ct = new CupTower();
		double amount = ct.liquidPoured(2, 1, 0);
		assertThat(amount, closeTo(0.5, 0.001));
	}
	
	@Test
	public void testTwoLayersOfCupAnotherOne() {
		CupTower ct = new CupTower();
		double amount = ct.liquidPoured(2, 1, 1);
		assertThat(amount, closeTo(0.5, 0.001));
	}

	@Test
	public void testThreeLayersOfCupMiddle() {
		CupTower ct = new CupTower();
		double amount = ct.liquidPoured(5, 2, 1);
		assertThat(amount, closeTo(1, 0.001));
	}
	
	@Test
	public void testThreeLayersOfCupFirst() {
		CupTower ct = new CupTower();
		double amount = ct.liquidPoured(5, 2, 0);
		assertThat(amount, closeTo(0.5, 0.001));
	}
}
