package com.niyue.coding.interviewstreet.changingbits;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private int N, Q;
    private int[] A, B;
    private Scanner scanner = new Scanner(System.in);
    private List<Set<Integer>> equalBits;
    private int noOfPartitions;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        getInput();
        for (int i = 0; i < Q; i++) {
            String op = scanner.next();
            char opCode = op.charAt(op.length() - 1);
            int bit = scanner.nextInt();
            if (opCode == 'c') {
                System.out.print(calc(A, B, bit));
            } else {
                int[] number = opCode == 'a' ? A : B;
                int bitSet = scanner.nextInt();
                if (number[bit] != bitSet) {
                    number[bit] = bitSet;
                    int partition = bit / noOfPartitions;
                    if (A[bit] == B[bit]) {
                        equalBits.get(partition).add(bit);
                    } else {
                        equalBits.get(partition).remove(bit);
                    }
                }
            }
        }
    }

    private int calc(int[] a, int[] b, int bit) {
        int higherSum = a[bit] + b[bit];
        Integer equalBit = searchMaxLowerEqualBits(bit);
        if (equalBit != null) {
            if (a[equalBit] == 1) {
                higherSum++;
            }
        }
        return higherSum & 1;
    }

    private Integer searchMaxLowerEqualBits(int bit) {
        Integer maxLowerEqualBit = null;
        if (bit > 0) {
            int partition = (bit - 1) / noOfPartitions;
            for (int i = partition; i >= 0; i--) {
                Set<Integer> equalBitsInPartition = equalBits.get(i);
                if (!equalBitsInPartition.isEmpty()) {
                    for (Integer equalBit : equalBitsInPartition) {
                        if (equalBit < bit) {
                            if (maxLowerEqualBit == null
                                    || equalBit > maxLowerEqualBit) {
                                maxLowerEqualBit = equalBit;
                            }
                        }
                    }
                    if (maxLowerEqualBit != null) {
                        break;
                    }
                }
            }
        }
        return maxLowerEqualBit;
    }

    private void getInput() {
        N = scanner.nextInt();
        Q = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        A = asBinary(a);
        B = asBinary(b);
        int nSquareRoot = (int) Math.sqrt(N);
        noOfPartitions = nSquareRoot * nSquareRoot == N ? nSquareRoot
                : nSquareRoot + 1;
        equalBits = findEqualBits(A, B);
    }

    private int[] asBinary(String number) {
        int[] binary = new int[N + 1];
        for (int i = 0; i < number.length(); i++) {
            binary[N - 1 - i] = number.charAt(i) - '0';
        }
        return binary;
    }

    private List<Set<Integer>> findEqualBits(int[] a, int[] b) {
        List<Set<Integer>> bits = new ArrayList<Set<Integer>>(noOfPartitions);
        int partitionSize = noOfPartitions;
        for (int i = 0; i < noOfPartitions; i++) {
            bits.add(new LinkedHashSet<Integer>());
        }
        for (int i = 0; i < N; i++) {
            if (a[i] == b[i]) {
                int partition = i / partitionSize;
                bits.get(partition).add(i);
            }
        }
        return bits;
    }
}
