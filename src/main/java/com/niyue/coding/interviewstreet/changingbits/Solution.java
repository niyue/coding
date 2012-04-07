package com.niyue.coding.interviewstreet.changingbits;

import java.util.Scanner;

public class Solution {
    private int N, Q;
    private int[] A, B;
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
                System.out.print(calc(A, B, bit));
            } else {
                int[] number = op == BitOp.SET_A ? A : B;
                int bitSet = scanner.nextInt();
                number[bit] = bitSet;
            }
        }
    }

    private int calc(int[] a, int[] b, int bit) {
        int higherSum = bit == N ? 0 : a[bit] + b[bit];
        for (int i = bit - 1; i >= 0; i--) {
            int sum = a[i] + b[i];
            if (sum == 0) {
                break;
            } else if (sum == 2) {
                higherSum += 1;
                break;
            }
        }
        return higherSum % 2;
    }

    private void getInput() {
        N = scanner.nextInt();
        Q = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        A = asBinary(a, N);
        B = asBinary(b, N);
    }

    private int[] asBinary(String number, int size) {
        int[] binary = new int[size];
        for (int i = 0; i < number.length(); i++) {
            binary[size - i - 1] = number.charAt(i) - '0';
        }
        return binary;
    }
}
