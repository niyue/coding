package com.niyue.coding.misc.reversebitarray;

// http://www.mitbbs.ca/clubarticle_t/New_Mommy_and_New_Daddy/20287063.html
public class BitArray {
	/*
	 * 0000
	 * 1000
	 * 0100
	 * 1100
	 * 0010
	 * 1010
	 * 0110
	 * 1110
	 * 0001
	 * 1001
	 * 0101
	 * 1101
	 * 0011
	 * 1011
	 * 0111
	 * 1111
	 */
	// NOTE: can be converted into binary literal in JDK 7 for better readability
	private static final byte[] map = new byte[] {
		0, 
		8, 
		4,
		12,
		2,
		10,
		6,
		14,
		1,
		9,
		5,
		13,
		3,
		11,
		7,
		15
	};
	
	public byte[] reverse(byte[] bits) {
		int mid = bits.length / 2;
		for(int i = 0; i < mid; i++) {
			swap(bits, i, bits.length - 1 - i);
			bits[i] = reverse(bits[i]);
			bits[bits.length - 1 - i] = reverse(bits[bits.length - 1 - i]);
		}
		if(bits.length % 2 != 0) {
			bits[mid] = reverse(bits[mid]);
		}
		return bits;
	}
	
	private void swap(byte[] bits, int i, int j) {
		byte temp = bits[i];
		bits[i] = bits[j];
		bits[j] = temp;
	}
	
	private byte reverse(byte bits) {
		return map[bits];
	}
}
