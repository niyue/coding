package com.niyue.coding.interviewstreet.stringsimilarity;

import java.util.ArrayList;
import java.util.List;
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
        	System.out.println(sum(string));
        }
    }

    private int sum(String s) {
    	return 0;
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