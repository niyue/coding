package com.niyue.coding.misc.twentysixexpbase;

/*
 * http://www.mitbbs.com/article_t1/JobHunting/32126949_0_1.html
 * A:0, B:1, C:2, ... , AA:26, AB:27, ... , given an integer, return corresponding string
 * 
 * Basically, this is a geometric sequence, A-Z (26 items) AA-ZZ (26^2 items), AAA-ZZZ (26^3 items)
 * Given an integer n, we need to:
 * 1) Figure out which section it belongs by using the formula for calculating the sum of geometric sequence (see exp function)
 * 2) Remove the items in prior sections by calculating the sum of geometric sequence
 * 3) The remaining number (n - sum) should be converted into a base 26 numbers
 */
public class TwentySixExpBase {
	public String convert(int n) {
		int exp = exp(n);
		int sum = sum(exp);
		String result = Integer.toString(n - sum, 26);
		result = transform(result, exp + 1);
		return result;
	}
	
	private int exp(int n) {
		return (int) (Math.log((n * 25 / 26.0 + 1)) / Math.log(26));
	}
	
	private int sum(int x) {
		return 26 * ((int) Math.pow(26, x) - 1) / 25;
	}
	
	private String transform(String base26, int padding) {
		char[] chars = base26.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			int diff = chars[i] < '9' ? 'a' - '0' : 10;
			chars[i] = (char) (chars[i] + diff);
		}
		return padding(new String(chars), padding);
	}
	
	private String padding(String s, int n) {
		String lengthFormat = "%" + n + "s";
		return String.format(lengthFormat, s).replace(' ', 'a');
	}
}
