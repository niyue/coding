package com.niyue.coding.misc.powerof3;

import java.util.HashSet;
import java.util.Set;

// http://stackoverflow.com/questions/1804311/how-to-check-if-an-integer-is-power-of-3
public class PowerOf3 {
	private static final Set<Integer> powerOfThree = generatePowers();
	
	private static Set<Integer> generatePowers() {
		Set<Integer> powers = new HashSet<Integer>();
		for(int power = 1, prev = 0; power > prev; prev = power, power *= 3) {
			powers.add(power);
		}
		return powers;
	}
			
	public boolean check(int number) {
		return powerOfThree.contains(number);
	}
}
