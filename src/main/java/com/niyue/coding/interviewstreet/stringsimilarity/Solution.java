package com.niyue.coding.interviewstreet.stringsimilarity;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private int T;
    private Map<String, Map<String, Long>> similarities = new HashMap<String, Map<String, Long>>();

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
            boolean found = false;
            String suffix = string.substring(i);
            if (similarities.containsKey(string)) {
                if (similarities.get(string).containsKey(suffix)) {
                    found = true;
                }
            } else {
                similarities.put(string, new HashMap<String, Long>());
            }
            long suffixSimilarity = found ? similarities.get(string)
                    .get(suffix) : similarity(string, i);
            if (!found) {
                similarities.get(string).put(suffix, suffixSimilarity);
            }
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