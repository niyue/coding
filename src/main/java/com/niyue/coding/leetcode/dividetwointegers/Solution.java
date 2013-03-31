package com.niyue.coding.leetcode.dividetwointegers;

// http://leetcode.com/onlinejudge#question_29
// Divide two integers without using multiplication, division and mod operator.
public class Solution {
    public int divide(int one, int two) {
    	long dividend = Math.abs((long) one);
    	long divisor = Math.abs((long) two);
		long quotient = div(dividend, divisor)[0];    
		return ((one ^ two) >> 31) == 0 ? (int) quotient : (int) -quotient;
    }

    private long[] div(long dividend, long divisor) {
    	long quotient = 0;
    	long remainder = 0;
    	if(dividend < divisor) {
    		remainder = dividend;
    	} else {
    		long[] result = div(dividend >> 1, divisor);
    		long halfQuotient = result[0];
    		long halfRemainder = result[1];
    		quotient = halfQuotient + halfQuotient;
    		long remainders = halfRemainder + halfRemainder + (dividend & 1);
    		if(remainders >= divisor) {
	    		remainder = remainders - divisor;
	    		quotient++;
    		} else {
    			remainder = remainders;
    		}
    	}
    	return new long[] {quotient, remainder};
    }
}
