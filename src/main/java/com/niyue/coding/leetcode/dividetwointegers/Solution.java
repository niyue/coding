package com.niyue.coding.leetcode.dividetwointegers;

// http://leetcode.com/onlinejudge#question_29
// Divide two integers without using multiplication, division and mod operator.
public class Solution {
    public int divide(int one, int two) {
    	long dividend = (long) one;
    	long divisor = (long) two;
		long quotient = 0;
		long sign = 1;
		if(dividend >= 0 && divisor <= 0 || dividend <= 0 && divisor >= 0) {
			sign = -1;
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);

		quotient = div(dividend, divisor)[0];    
		return sign == 1 ? (int) quotient : 0 - (int) quotient;
    }

    private long[] div(long dividend, long divisor) {
    	long quotient = 0;
    	long remainder = 0;
    	if(dividend == divisor) {
    		quotient = 1;
    	} else if(dividend < divisor) {
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
