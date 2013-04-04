package com.niyue.coding.leetcode.multiplystrings;

// http://leetcode.com/onlinejudge#question_43
public class Solution {
    public String multiply(String num1, String num2) {
        int[] one = asIntegers(num1);
        int[] two = asIntegers(num2);
        int[] product = multiply(one, two);
        return asString(product);
    }

    private int[] asIntegers(String num) {
        char[] chars = num.toCharArray();
        int[] ints = new int[chars.length];
        for(int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] - '0';
        }
        return ints;
    }

    private String asString(int[] num) {
        StringBuffer product = new StringBuffer();
        boolean isLeadingZero = true;
        for(int i = 0; i < num.length; i++) {
            isLeadingZero = num[i] == 0 && isLeadingZero && i != num.length - 1;
            if(!isLeadingZero) {
                product.append(num[i]);
            }
        }
        return product.toString();
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
}
