package com.niyue.coding.careercup.stringserialization;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
		List<String> result = new ArrayList<String>();
		string = unbracket(string);
		for(String s : string.split(", ")) {
			result.add(unescape(unquote(s)));
		}
		return result;
	}
	
	private String unbracket(String s) {
		return s.substring(1, s.length() - 1);
	}
	
	private String unquote(String s) {
		return s.substring(1, s.length() - 1);
	}
	
	private String unescape(String s) {
		return s.replace("''", "'");
	}
}
