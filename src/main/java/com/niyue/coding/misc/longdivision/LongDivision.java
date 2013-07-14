package com.niyue.coding.misc.longdivision;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

// http://www.mitbbs.com/article_t1/JobHunting/32287847_0_3.html
public class LongDivision {
	public String divide(int a, int b) {
		String integerPart = String.valueOf(a / b);
		String fractionPart = fraction(a % b, b);
		return String.format("%s.%s", integerPart, fractionPart);
	}
	
	private String fraction(int a, int b) {
		Map<Integer, Integer> remainders = new LinkedHashMap<Integer, Integer>();
		int recur = 0;
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
