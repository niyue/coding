package com.niyue.coding.leetcode.integertoroman;

// http://leetcode.com/onlinejudge#question_12
// http://en.wikipedia.org/wiki/Roman_numerals
public class Solution {
    private StringBuilder roman;
    public String intToRoman(int num) {
        roman = new StringBuilder();
        if(num > 0 && num < 4000) {
        	roman(num, 1000, "", "", "", "M");
        	roman(num % 1000, 100, "CM", "D", "CD", "C");
        	roman(num % 100, 10, "XC", "L", "XL", "X");
        	roman(num % 10, 1, "IX", "V", "IV", "I");
        }
        return roman.toString();
    }

    private void roman(int num, int base, String nine, String five, String four, String one) {
        int digit = num / base;
        if(digit == 9) {
            roman.append(nine);
            digit -= 9;
        } else if(digit >= 5) {
            roman.append(five);
            digit -= 5;
        } else if(digit == 4) {
            roman.append(four);
            digit -= 4; 
        }
        for(int i = 0; i < digit; i++) {
            roman.append(one);
        }
    }
}
