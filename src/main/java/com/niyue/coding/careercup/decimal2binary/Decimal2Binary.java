package com.niyue.coding.careercup.decimal2binary;

// http://www.careercup.com/question?id=4116672
public class Decimal2Binary {
	public String convert(float decimal) {
		int integer = (int) decimal;
		String integerPart = integerToBinary(integer);
		float fraction = decimal - integer;
		String fractionPart = fractionToBinary(fraction);
		return fractionPart.isEmpty()
				? String.format("%s", integerPart) 
				: String.format("%s.%s", integerPart, fractionPart);
	}
	
	private String integerToBinary(int integer) {
		StringBuilder s = new StringBuilder();
		do {
			s.append(integer & 1);
			integer = integer >> 1;
		} while(integer > 0);
		return s.reverse().toString();
	}
	
	private String fractionToBinary(float fraction) {
		StringBuilder s = new StringBuilder();
		float epsilon = 0.0000001f;
		while(fraction > epsilon) {
			fraction = fraction * 2;
			if(fraction >= 1) {
				s.append("1");
				fraction -= 1;
			} else {
				s.append("0");
			}
		}
		return s.toString();
	}
}
