package com.niyue.coding.interviewstreet.practices.twoscomplement;

import java.util.Scanner;

class Solution {
    private int T;
    private long[] countsForTwo = new long[32];
    private int[] A, B;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        getInput();
        
        countsForTwo[0] = 1;
        for(int i=1;i<32;i++) {
        	countsForTwo[i] = (1 << (i-1)) + 2 * countsForTwo[i-1] - 1;
        }
        
        for(int i=0;i<T;i++) {
        	int a = A[i] > 0 ? A[i] - 1 : A[i];
        	int b = B[i] < 0 ? B[i] + 1 : B[i];
        	long countA = count(a);
        	long countB = count(b);
        	long count = A[i] <= 0 && B[i] >=0 ? countA + countB : Math.abs(countB - countA);
        	System.out.println(count);
        }
    }
    
    private long count(int number) {
    	long count = 0;
    	if(number < 0) {
    		count = -32 * (long) number - count(-1 * number - 1);
    	} else if(number > 0) {
    		int nearestPowerOfTwo = nearestPowerOfTwo(number);
    		int remaining = number - nearestPowerOfTwo;
    		int twoExp = twoExp(nearestPowerOfTwo);
    		count = remaining + countsForTwo[twoExp] + count(remaining);
    	}
    	return count;
    }
    
    private int nearestPowerOfTwo(int number) {
    	return Integer.highestOneBit(number);
    }
    
    private int twoExp(int powerOfTwo) {
    	return Integer.numberOfTrailingZeros(powerOfTwo);
    }

    private void getInput() {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        A = new int[T];
        B = new int[T];
        for(int i=0;i<T;i++) {
        	A[i] = scanner.nextInt();
        	B[i] = scanner.nextInt();
        }
    }
}
