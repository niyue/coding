package com.niyue.coding.leetcode.dividetwointegers;

public class IterativeSolution {
    public int divide(int one, int two) {
    	long dividend = Math.abs((long) one);
    	long divisor = Math.abs((long) two);
		long quotient = div(dividend, divisor);    
		return ((one ^ two) >> 31) == 0 ? (int) quotient : (int) -quotient;
    }

    private long div(long dividend, long divisor) {
    	long quotient = 0;
    	while(dividend >= divisor) {
    		long d = divisor;
    		for(int i = 0; dividend >= d; i++, d <<= 1) {
    			dividend -= d;
    			quotient += (1 << i);
    		}
    	}
    	return quotient;
    }
}
