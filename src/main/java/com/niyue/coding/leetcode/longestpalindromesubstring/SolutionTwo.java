package com.niyue.coding.leetcode.longestpalindromesubstring;

/*
 * http://oj.leetcode.com/problems/longest-palindromic-substring/
 * O(n^2) solution, consider each character and the space between two characters as the center of a palindrome string
 * expand both end of a palindrome string from a center to see if it is expandable to be a longer palindrome
 */
public class SolutionTwo {
    public String longestPalindrome(String s) {
        String lp = "";
        for(int i = 0; i < s.length() * 2 - 1; i++) {
            String palindrome = longestPalindrome(s, i / 2, i % 2 != 0);
            if(palindrome.length() > lp.length()) {
                lp = palindrome;
            }
        }        
        return lp;
    }
    
    private String longestPalindrome(String s, int i, boolean isOdd) {
        int start = isOdd ? i: i - 1;
        int end = i + 1;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
