package com.niyue.coding.leetcode.longestpalindromesubstring;

// Find the longest palindromic substring for a string
// http://leetcode.com/onlinejudge#question_5
public class Solution {
    public String longestPalindrome(String s) {
        int longest = 0;
        char[] chars = s.toCharArray();
        int longestPalindromeIndex = 0;
        for(int i = 0;i < chars.length;i++) {
            int longestOdd = longestPalindrome(chars, i, true);
            int longestEven = longestPalindrome(chars, i, false);
            int longestAtI = Math.max(longestOdd, longestEven);
            if(longestAtI > longest) {
                longest = longestAtI;
                longestPalindromeIndex = i;
            }
        }
        int begin = longest % 2 == 0 
            ? longestPalindromeIndex - (longest - 2) / 2
            : longestPalindromeIndex - longest / 2;
        int end = begin + longest;
        return s.substring(begin, end);
    }
    
    private int longestPalindrome(char[] chars, int i, boolean isOdd) {
        int length = isOdd ? 1 : 0;
        int left = isOdd ? i - 1 : i;
        int right = i + 1;
        while(left >= 0 && right < chars.length && chars[left] == chars[right]) {
            length += 2;
            left--;
            right++;
        }
        return length;
    }
}
