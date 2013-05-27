package com.niyue.coding.careercup.digitinseq;

/**
 * 
 * find the ith digit in a 01234567891011 sequence
 * http://www.careercup.com/question?id=15382717
 *
 */
public class DigitInSeq {
    public int get(int n) {
        int start = 0;
        int end = 9;
        int digits = 1;
        int digit = 0;
        int total = 10;
        int length = 10;
        while(n > total) {
            n -= length;

            start = end + 1;
            end = end * 10 + 9;
            length = end - start + 1;
            digits++;
            total = digits * length;
        }
        digit = Integer.toString(start + (n / digits)).charAt(n % digits) - '0';
        return digit;
    }
}
