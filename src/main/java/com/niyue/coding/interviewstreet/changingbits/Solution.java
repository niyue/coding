package com.niyue.coding.interviewstreet.changingbits;

import java.util.Scanner;

public class Solution {
    private int N, Q;
    private int[] A, B, C;
    private Scanner scanner = new Scanner(System.in);

    private enum BitOp {
        SET_A, SET_B, GET_C;
        public static BitOp fromValue(String op) {
            BitOp bitOp = GET_C;
            char lastChar = op.charAt(op.length() - 1);
            if (lastChar == 'a') {
                bitOp = SET_A;
            } else if (lastChar == 'b') {
                bitOp = SET_B;
            }
            return bitOp;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        getInput();
        for (int i = 0; i < Q; i++) {
            BitOp op = BitOp.fromValue(scanner.next());
            int bit = scanner.nextInt();
            if (op == BitOp.GET_C) {
                System.out.print(C[bit]);
            } else {
                int bitSet = scanner.nextInt();
                int[] number = A;
                if (op == BitOp.SET_B) {
                    number = B;
                }
                if (bitSet > number[bit]) {
                    int lowCarry = (A[bit] + B[bit]) % 2 == C[bit] ? 0 : 1;
                    number[bit] = 1;
                    carryBit(bit, true, lowCarry);
                } else if (bitSet < number[bit]) {
                    int lowCarry = (A[bit] + B[bit]) % 2 == C[bit] ? 0 : 1;
                    number[bit] = 0;
                    carryBit(bit, false, lowCarry);
                }
                // ignore if bitSet == number[bit]
            }
        }
    }

    private void carryBit(int bit, boolean increase, int lowCarry) {
        int carry = lowCarry;
        int i = bit;
        if (increase) {
            for (; i < N; i++) {
                int sum = A[i] + B[i] + carry;
                C[i] = sum % 2;
                if (sum < 2) {
                    carry = 0;
                    break;
                } else {
                    carry = 1;
                }
            }
        } else {
            for (; i < N; i++) {
                int sum = A[i] + B[i] + carry;
                C[i] = sum % 2;
                if (sum < 2) {
                    carry = 0;
                } else {
                    carry = 1;
                    break;
                }
            }
        }
        if (i == N) {
            C[i] = carry;
        }
    }

    private void getInput() {
        N = scanner.nextInt();
        Q = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        A = asBinary(a, N);
        B = asBinary(b, N);
        C = add(A, B);
    }

    private int[] asBinary(String number, int size) {
        int[] binary = new int[size];
        for (int i = 0; i < number.length(); i++) {
            binary[size - i - 1] = number.charAt(i) - '0';
        }
        return binary;
    }

    private int[] add(int[] a, int[] b) {
        int[] sums = new int[N + 1];
        int carry = 0;
        for (int i = 0; i < N; i++) {
            int sum = a[i] + b[i] + carry;
            sums[i] = sum % 2;
            carry = sum > 1 ? 1 : 0;
        }
        sums[N] = carry;
        return sums;
    }
}
