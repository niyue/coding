package com.niyue.coding.misc.deladoubleb;

/*
 * Process a string, remove all 'a' from the string, and double all 'b' in the string
 * The original problem may ask to do this in place, but the problem description is not so clear
 */
public class DelADoubleB {
	public String process(String s) {
		StringBuilder ss = new StringBuilder();
		for(char c : s.toCharArray()) {
			if(c == 'b') {
				ss.append(c).append(c);
			} else if(c != 'a') {
				ss.append(c);
			}
		}
		return ss.toString();
	}
}
