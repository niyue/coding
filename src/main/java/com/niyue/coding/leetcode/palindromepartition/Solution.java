package com.niyue.coding.leetcode.palindromepartition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// http://leetcode.com/onlinejudge#question_131
// pre-process the string to get all palindromes and store them as (start, end), O(n^2)
// try all possible partition scheme, and use DP to speed up a bit (back tracking solution without memoization is too slow to pass the online judge)
public class Solution {
    private ArrayList<ArrayList<String>>[] solutionsCache;
    @SuppressWarnings("unchecked")
    public ArrayList<ArrayList<String>> partition(String s) {
        solutionsCache = new ArrayList[s.length()];
        Map<Integer, List<Integer>> map = allPalindromes(s);
        solve(s, 0, map);
        return solutionsCache[0];
    }
    
    private ArrayList<ArrayList<String>> solve(String s, int i, Map<Integer, List<Integer>> map) {
        ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>>();
        if(solutionsCache[i] != null) {
            solutions = solutionsCache[i];
        } else {
            for(int end : map.get(i)) {
                String p = s.substring(i, end + 1);
                if(end + 1 == s.length()) {
                    ArrayList<String> solution = new ArrayList<String>();
                    solution.add(p);
                    solutions.add(solution);
                } else {
                    ArrayList<ArrayList<String>> subSolutions = solve(s, end + 1, map);
                    for(ArrayList<String> subSolution : subSolutions) {
                        ArrayList<String> solution = new ArrayList<String>();
                        solution.add(p);
                        solution.addAll(subSolution);
                        solutions.add(solution);
                    }    
                }
            }
            solutionsCache[i] = solutions;
        }    
        
        return solutions;
    }
    
    private Map<Integer, List<Integer>> allPalindromes(String s) {
        Map<Integer, List<Integer>> palindromes = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < s.length(); i++) {
            for(int start = i, end = i; start >= 0 && end < s.length(); start--, end++) {
            	if(!isPalindrome(s, start, end, palindromes)) {
            		break;
            	}
            }
            for(int start = i, end = i + 1; start >= 0 && end < s.length(); start--, end++) {
            	if(!isPalindrome(s, start, end, palindromes)) {
            		break;
            	}
            }
        }
        return palindromes;
    }
    
    private boolean isPalindrome(String s, int start, int end, Map<Integer, List<Integer>> palindromes) {
    	boolean isPalindrome = false;
    	if(s.charAt(start) == s.charAt(end)) {
    		if(!palindromes.containsKey(start)) {
    			palindromes.put(start, new LinkedList<Integer>());
    		}
    		palindromes.get(start).add(end);
    		isPalindrome = true;
    	}
    	return isPalindrome;
    }
}