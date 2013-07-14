package com.niyue.coding.misc.numberformat;

/*
 * convert an integer into format like sign * a * 2^b
 * 7 = +1 * 7 * 2^0
 */
public class NumberFormat {
	private static final String POSITIVE_SIGN = "+1";
	private static final String NEGATIVE_SIGN = "(-1)";
	
	public String convert(int n) {
		int b = Integer.numberOfTrailingZeros(n);
		int a = n >> b;
		String sign = POSITIVE_SIGN;
		if(n < 0) {
			sign = NEGATIVE_SIGN;
			a *= -1;
		}
		return String.format("%s * %s * 2^%s", sign, a, b);
	}
}
