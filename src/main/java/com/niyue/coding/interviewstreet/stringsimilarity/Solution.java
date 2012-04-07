package com.niyue.coding.interviewstreet.stringsimilarity;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private int T;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        List<String> strings = getInput();
        for (String string : strings) {
            System.out.println(similarity(string));
        }
    }

    private long similarity(String string) {
        long count = 0;
        for (int i = 0; i < string.length(); i++) {
            long suffixSimilarity = similarity(string, i);
            count += suffixSimilarity;
        }
        return count;
    }

    private long similarity(String string, int suffixIndex) {
        long similarity = 0;
        for (int i = 0; i < string.length() - suffixIndex; i++) {
            if (string.charAt(i) == string.charAt(suffixIndex + i)) {
                similarity++;
            } else {
                break;
            }
        }
        return similarity;
    }

    private List<String> getInput() {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        List<String> strings = new ArrayList<String>(T);
        for (int i = 0; i < T; i++) {
            strings.add(scanner.next());
        }
        return strings;
    }
}