package com.niyue.coding.misc.fourless;

// http://www.mitbbs.com/article_t/JobHunting/32281037.html
public class Fourless {
	public int translate(int n) {
		String base9 = convert(n);
		// NOTE: radix conversion, Integer.parseInt(string, radix) is the same as Integer.valueOf(string, radix)
		return Integer.parseInt(base9, 9);
	}
	
	private String convert(int n) {
		char[] chars = new Integer(n).toString().toCharArray();
		for(int i = 0; i < chars.length; i++) {
			chars[i] = map(chars[i]);
		}
		return new String(chars);
	}
	
	private char map(char digit) {
		if(digit == '4') {
			throw new IllegalArgumentException("4 is not allowed");
		}
		return digit < '4' ? digit : (char) (digit - 1);
	}
}
