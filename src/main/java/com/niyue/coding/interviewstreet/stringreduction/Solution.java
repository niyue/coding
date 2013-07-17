package com.niyue.coding.interviewstreet.stringreduction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private int T;
    private Map<String, Integer> countTable = new HashMap<String, Integer>();

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        List<String> strings = getInput();
        for (String string : strings) {
            System.out.println(reduceCount(string));
        }
    }

    private int reduceCount(String string) {
        if (string.length() == 1) {
            return 1;
        }
        if (string.length() == 2) {
            return isReducible(string, 0) ? 1 : 2;
        }
        int count = string.length();
        for (int i = 0; i < string.length() - 1; i++) {
            if (isReducible(string, i)) {
                String reducedString = reduce(string, i);
                int reducedStringCount = countTable.containsKey(reducedString) ? countTable
                        .get(reducedString) : reduceCount(reducedString);
                if (reducedStringCount < count) {
                    count = reducedStringCount;
                }
            }
        }
        countTable.put(string, count);
        return count;
    }

    private String reduce(String string, int startIndex) {
        char one = string.charAt(startIndex);
        char two = string.charAt(startIndex + 1);
        char newChar = 'a';
        String reducedString = null;
        if (one == 'a' && two == 'b' || one == 'b' && two == 'a') {
            newChar = 'c';
        } else if (one == 'a' && two == 'c' || one == 'c' && two == 'a') {
            newChar = 'b';
        }
        if (startIndex == 0) {
            reducedString = newChar + string.substring(2);
        } else if (startIndex + 2 < string.length()) {
            reducedString = string.substring(0, startIndex) + newChar
                    + string.substring(startIndex + 2);
        } else {
            reducedString = string.substring(0, startIndex) + newChar;
        }
        return reducedString;
    }

    private boolean isReducible(String string, int startIndex) {
        return string.charAt(startIndex) != string.charAt(startIndex + 1);
    }

    private List<String> getInput() {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        List<String> strings = new ArrayList<String>(T);
        for (int i = 0; i < T; i++) {
            strings.add(scanner.next());
        }
        scanner.close();
        return strings;
    }
}
