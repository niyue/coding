package com.niyue.coding.interviewstreet.stringsimilarity;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private int T;
    private Map<Integer, Map<Integer, Long>> similarities;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        List<String> strings = getInput();
        for (String string : strings) {
            similarities = new HashMap<Integer, Map<Integer, Long>>();
            System.out.println(similarity(string));
        }
    }

    private long similarity(String string) {
        long count = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            long suffixSimilarity = similarity(string, 0, i);
            count += suffixSimilarity;
        }
        return count;
    }

    private long similarity(String string, int startIndex, int suffixIndex) {
        long similarity = 0;
        if (hasSolution(startIndex, suffixIndex)) {
            similarity = similarities.get(startIndex).get(suffixIndex);
        } else {
            if (string.length() > suffixIndex) {
                if (string.charAt(startIndex) == string.charAt(suffixIndex)) {
                    similarity = 1 + similarity(string, startIndex + 1,
                            suffixIndex + 1);
                }
                setSolution(startIndex, suffixIndex, similarity);
            }
        }

        return similarity;
    }

    private boolean hasSolution(int startIndex, int suffixIndex) {
        boolean hasSolution = false;
        if (similarities.containsKey(startIndex)) {
            hasSolution = similarities.get(startIndex).containsKey(suffixIndex);
        }
        return hasSolution;
    }

    private void setSolution(int startIndex, int suffixIndex, long similarity) {
        if (!similarities.containsKey(startIndex)) {
            similarities.put(startIndex, new HashMap<Integer, Long>());
        }
        similarities.get(startIndex).put(suffixIndex, similarity);
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