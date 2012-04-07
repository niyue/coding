package com.niyue.coding.interviewstreet.changingbits;

import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {
    private int N, Q;
    private int[] A, B;
    private Scanner scanner = new Scanner(System.in);
    private NavigableSet<Integer> equalBits;

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
                    if (A[bit] == B[bit]) {
                        equalBits.add(bit);
                    } else {
                        equalBits.remove(bit);
                    }
                }
            }
        }
    }

    private int calc(int[] a, int[] b, int bit) {
        int higherSum = bit == N ? 0 : a[bit] + b[bit];
        Integer equalBit = equalBits.lower(bit);
        if (equalBit != null) {
            if (a[equalBit] == 1) {
                higherSum++;
            }
        }
        return higherSum & 1;
    }

    private void getInput() {
        N = scanner.nextInt();
        Q = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        A = asBinary(a);
        B = asBinary(b);
        equalBits = findEqualBits(A, B);
    }

    private int[] asBinary(String number) {
        int[] binary = new int[N];
        for (int i = 0; i < number.length(); i++) {
            binary[N - 1 - i] = number.charAt(i) - '0';
        }
        return binary;
    }

    private NavigableSet<Integer> findEqualBits(int[] a, int[] b) {
        NavigableSet<Integer> bits = new TreeSet<Integer>();
        for (int i = 0; i < N; i++) {
            if (a[i] == b[i]) {
                bits.add(i);
            }
        }
        return bits;
    }
}
