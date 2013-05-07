package com.niyue.coding.careercup.stringserialization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * http://www.careercup.com/question?id=3507065
 * a string returned from 'serialize' can be passed into deserialize to get the original set of strings back.
 * for serializing, when a string is deseirialized, each string is single quoted and joined together with comma and whitespace
 * for deseriializing, a finite state machine with three states is introduced to track the current status of string processing. 
 */
public class StringSerialization {
	public String serialize(List<String> strings) {
		List<String> serilizedString = new LinkedList<String>();
		for(String s : strings) {
			serilizedString.add(quote(escape(s)));
		}
		return serilizedString.toString();
	}
	
	private String quote(String s) {
		return String.format("'%s'", s);
	}
	
	private String escape(String s) {
		return s.replace("'", "''");
	}
	
	public List<String> deserialize(String string) {
		string = unbracket(string);
		State state = State.BEFORE_QUOTE;
		List<String> result = new ArrayList<String>();
		StringBuilder currentString = null;
		char[] chars = string.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if(state == State.BEFORE_QUOTE) {
				if(Character.isWhitespace(c)) {
					continue;
				}
				if(c == '\'') {
					state = State.IN_QUOTE;
					currentString = new StringBuilder();
				} else {
					throw new IllegalArgumentException(String.format("Invalid serialization at character %s", c));
				}
			} else if(state == State.IN_QUOTE) {
				if(c == '\'' && i < chars.length - 1 && chars[i + 1] == '\'') {
					currentString.append(c);
					i++;
				} else if(c == '\'') {
					result.add(currentString.toString());
					state = State.AFTER_QUOTE;
				} else {
					currentString.append(c);
				}
			} else {
				if(Character.isWhitespace(c)) {
					continue;
				}
				if(c == ',') {
					state = State.BEFORE_QUOTE;
				}
			}
		}
		return result;
	}
	
	private String unbracket(String s) {
		if(s.charAt(0) == '[' && s.charAt(s.length() - 1) == ']') {
			return s.substring(1, s.length() - 1);
		} else {
			throw new IllegalArgumentException("Invalid serialization, brackets are needed");
		}
	}
	
	private enum State {
		BEFORE_QUOTE,
		IN_QUOTE,
		AFTER_QUOTE
	}
}
