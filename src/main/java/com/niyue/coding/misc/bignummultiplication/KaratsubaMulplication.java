package com.niyue.coding.misc.bignummultiplication;

import java.math.BigInteger;

// http://www.mitbbs.ca/clubarticle_t/New_Mommy_and_New_Daddy/20287063.html
// http://en.wikipedia.org/wiki/Multiplication_algorithm#Karatsuba_multiplication
// http://ozark.hendrix.edu/~burch/csbsju/cs/160/notes/31/1.html
// http://nayuki.eigenstate.org/page/karatsuba-multiplication
// O(n^log(2, 3)) time complexity
public class KaratsubaMulplication {
	// the threshold can be set to a larger value in production for better performance
	private static final int THRESHOLD = 3;
	/*
	 * This implementation handle the multiplication using bits instead of base 10 digits
	 * which is very convenient when used together with BigInteger.shiftLeft/Right
	 */
	public BigInteger multiply(BigInteger x, BigInteger y) {
		BigInteger product = null;
		
		if(x.bitLength() < THRESHOLD || y.bitLength() < THRESHOLD) {
			product = x.multiply(y);
		} else {
			int half = Math.max(x.bitLength(), y.bitLength()) / 2;
			BigInteger x1 = x.shiftRight(half);
			// NOTE: learn how to get a all 1 mask in one line
			BigInteger mask = BigInteger.ONE.shiftLeft(half).subtract(BigInteger.ONE);
			BigInteger x2 = x.and(mask);
			BigInteger y1 = y.shiftRight(half);
			BigInteger y2 = y.and(mask);
			
			BigInteger x1y1 = multiply(x1, y1);
			BigInteger x2y2 = multiply(x2, y2);
			BigInteger c = multiply(x1.add(x2), y1.add(y2));
			BigInteger k = c.subtract(x1y1).subtract(x2y2);
			product = x1y1.shiftLeft(half).add(k).shiftLeft(half).add(x2y2);
		}
		
		return product;
	}
}
