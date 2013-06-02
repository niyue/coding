package com.niyue.coding.careercup.syncreader;

import java.util.Iterator;
import java.util.List;

import com.google.common.primitives.Chars;

public class CharStream {
	private final List<Character> chars;
	private Iterator<Character> iter;
	
	public CharStream(String chars) {
		this.chars = Chars.asList(chars.toCharArray());
		this.iter = this.chars.iterator();
	}
	
	public char read() {
		return iter.hasNext() ? iter.next() : Character.MIN_VALUE;
	}
}
