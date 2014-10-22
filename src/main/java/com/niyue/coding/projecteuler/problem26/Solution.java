package com.niyue.coding.projecteuler.problem26;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
	public String longestRecurringCycle() {
		String maxRecurringCycle = "";
	
		for(int d = 2; d < 1000; d++) {
			String recurringCycle = recurringCycle(d);
			if(recurringCycle.length() > maxRecurringCycle.length()) {
				maxRecurringCycle = recurringCycle;
			}
		}
		return String.format("0.%s", maxRecurringCycle);
	}
	
	private String recurringCycle(int d) {
		Map<Integer, Integer> remainders = new LinkedHashMap<Integer, Integer>();
		int recur = 0;
		int a = 1;
		int b = d;
		while(true) {
			int quotient = a * 10 / b;
			int nextRemainder = a * 10 % b;
			if(!remainders.containsKey(a)) {
				remainders.put(a, quotient);
				a = nextRemainder;
			} else {
				recur = a;
				break;
			}
		}
		return toString(remainders, recur);
	}
	
	private String toString(Map<Integer, Integer> remainders, int recur) {
		StringBuilder fraction = new StringBuilder();
		for(Entry<Integer, Integer> entry : remainders.entrySet()) {
			int remainder = entry.getKey();
			if(remainder == recur) {
				fraction.append("(");
			}
			fraction.append(entry.getValue());
		}
		fraction.append(")");
		return fraction.toString();
	}
}
