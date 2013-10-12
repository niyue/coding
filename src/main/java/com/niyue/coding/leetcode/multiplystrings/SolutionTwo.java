package com.niyue.coding.leetcode.multiplystrings;

/*
 * http://oj.leetcode.com/problems/multiply-strings/
 */
public class SolutionTwo {
    public String multiply(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int[] product = new int[n1.length + n2.length + 1];
        for(int i = 0; i < n2.length; i++) {
            for(int j = 0; j < n1.length; j++) {
                product[i + j] += (n1[n1.length - 1 - j] - '0') * (n2[n2.length - 1 - i] - '0');
                product[i + j + 1] += product[i + j] / 10;
                product[i + j] %= 10;
            }
        }
        return toString(product);
    }
    
    private String toString(int[] product) {
        StringBuilder s = new StringBuilder();
        boolean isLeadingZero = true;
        for(int i = product.length - 1; i >= 0; i--) {
        	if(product[i] > 0) {
                isLeadingZero = false;
                s.append(product[i]);
            } else if(product[i] == 0 && !isLeadingZero) {
            	s.append(product[i]);
            }
        }
        return s.length() == 0 ? "0" : s.toString();
    }
}
