package com.niyue.coding.careercup.multiplication;

import java.util.Scanner;

/*
 * Two very large numbers are represented using arrays. 
 * Multiply these two numbers. E.g. Two numbers 12 and 13 are represented as a=[1,2] and b=[1,3]. 
 * The expected result is 12*13=156 i.e. c=[1,5,6]
 */
class Solution {
	private int[] one, two;
    
    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
    	getInput();
    	int[] product = multiply(one, two);
    	if(product[0] != 0) {
    		System.out.print(product[0]);
    	}
    	for(int i=1;i<product.length;i++) {
    		System.out.print(product[i]);
    	}
    }
    
    int[] multiply(int[] one, int[] two) {
    	int[] product = new int[one.length + two.length];
    	for(int i=two.length-1;i>=0;i--) {
    		int[] subProduct = multiply(one, two[i], two.length-1-i);
    		product = add(product, subProduct);
    	}
    	return product;
    }
    
    int[] multiply(int[] one, int digit, int shift) {
    	int[] product = new int[one.length+1+shift];
    	int carry = 0;
    	for(int i=one.length-1;i>=0;i--) {
    		int p = one[i] * digit + carry;
    		int currentDigit = p % 10;
    		carry = p / 10;
    		product[i+1] = currentDigit; 
    	}
    	product[0] = carry;
    	return product;
    }
    
    int[] add(int[] a, int[] b) {
    	// la >= lb
    	int la = a.length - 1;
    	int lb = b.length - 1;
    	int[] sum = new int[a.length];
    	int carry = 0;
    	
    	while(lb >= 0) {
    		int addition = a[la] + b[lb] + carry;
    		sum[la] = addition % 10;
    		carry = addition / 10;
    		la--;
    		lb--;
    	}
    	while(la >= 0) {
    		int addition = a[la] + carry;
    		sum[la] = addition % 10;
    		carry = addition / 10;
    		la--;
    	}
    	return sum;
    }
    
    private void getInput() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        one = new int[m];
        for(int i=0;i<m;i++) {
        	one[i] = scanner.nextInt();
        }
        two = new int[n];
        for(int i=0;i<n;i++) {
        	two[i] = scanner.nextInt();
        }
        scanner.close();
    }
}
