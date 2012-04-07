package com.niyue.coding.interviewstreet.kdifference;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private int N, K;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        Set<Integer> numbers = getInput();
        int count = 0;
        for (Integer number : numbers) {
            int small = number - K;
            int big = number + K;
            if (numbers.contains(small)) {
                count++;
            }
            if (numbers.contains(big)) {
                count++;
            }
        }
        count = count / 2;
        System.out.println(count);
    }

    private Set<Integer> getInput() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        Set<Integer> inputNumbers = new HashSet<Integer>(N);
        for (int i = 0; i < N; i++) {
            inputNumbers.add(scanner.nextInt());
        }
        return inputNumbers;
    }
}
