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
            long suffixSimilarity = similarity(string, string.substring(i));
            count += suffixSimilarity;
        }
        return count;
    }

    private long similarity(String string, String suffix) {
        long similarity = 0;
        if (hasSolution(string, suffix)) {
            similarity = similarities.get(string).get(suffix);
        } else {
            if (suffix.length() > 0) {
                if (string.charAt(0) == suffix.charAt(0)) {
                    similarity = 1 + similarity(string.substring(1),
                            suffix.substring(1));
                }
                setSolution(string, suffix, similarity);
            }
        }

        return similarity;
    }

    private boolean hasSolution(String string, String suffix) {
        boolean hasSolution = false;
        if (similarities.containsKey(string)) {
            hasSolution = similarities.get(string).containsKey(suffix);
        }
        return hasSolution;
    }

    private void setSolution(String string, String suffix, long similarity) {
        if (!similarities.containsKey(string)) {
            similarities.put(string, new HashMap<String, Long>());
        }
        similarities.get(string).put(suffix, similarity);
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