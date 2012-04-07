package com.niyue.coding.interviewstreet.changingbits;

import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    private int N, Q;
    private BitSet A, B;
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
                BitSet number = op == BitOp.SET_A ? A : B;
                boolean bitSet = scanner.nextInt() == 1;
                number.set(bit, bitSet);
            }
        }
    }

    private int calc(BitSet a, BitSet b, int bit) {
        boolean higherSum = bit == N ? false : a.get(bit) != b.get(bit);
        for (int i = bit - 1; i >= 0; i--) {
            boolean aBitSet = a.get(i);
            boolean bBitSet = b.get(i);
            if (!aBitSet && !bBitSet) {
                break;
            } else if (aBitSet && bBitSet) {
                higherSum = !higherSum;
                break;
            }
        }
        return higherSum ? 1 : 0;
    }

    private void getInput() {
        N = scanner.nextInt();
        Q = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();
        A = asBinary(a, N);
        B = asBinary(b, N);
    }

    private BitSet asBinary(String number, int size) {
        BitSet binary = new BitSet(size);
        for (int i = 0; i < number.length(); i++) {
            boolean bitSet = (number.charAt(i) - '0') == 1;
            binary.set(size - i - 1, bitSet);
        }
        return binary;
    }
}
