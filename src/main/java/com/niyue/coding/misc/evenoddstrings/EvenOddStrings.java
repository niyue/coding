package com.niyue.coding.misc.evenoddstrings;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of strings, every string appears even times except one. Find out that one.
 * XOR the bytes for each of the strings, for string with smaller length, use zero byte in the front for XOR
 */
public class EvenOddStrings {
	public String findOdd(String[] strings) {
		List<byte[]> bytesList = new ArrayList<byte[]>();
		int maxLength = 0;
		Charset utf16 = Charset.forName("UTF-16");
		for(String s : strings) {
			byte[] bytes = s.getBytes(utf16);
			bytesList.add(bytes);
			if(bytes.length > maxLength) {
				maxLength = bytes.length;
			}
		}
		byte[] xor = new byte[maxLength];
		for(byte[] bytes : bytesList) {
			for(int bi = 0; bi < maxLength; bi++) {
				byte b = bi < bytes.length ? bytes[bi] : 0;
				xor[bi] = (byte) (xor[bi] ^ b);
			}
		}
		return new String(xor, utf16);
	}
}
