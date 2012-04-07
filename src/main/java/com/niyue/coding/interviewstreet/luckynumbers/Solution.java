package com.niyue.coding.interviewstreet.luckynumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    private int T;
    private long[] startNumbers;
    private long[] endNumbers;
    private Map<Long, Boolean> solution = new HashMap<Long, Boolean>();

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        getInput();

        for (int i = 0; i < T; i++) {
            long start = startNumbers[i];
            long end = endNumbers[i];
            long count = 0;
            for (long j = start; j <= end; j++) {
                List<Integer> digits = digits(j);
                long fingerPrint = fingerPrint(digits);
                boolean isLucky = false;
                if (solution.containsKey(fingerPrint)) {
                    isLucky = solution.get(fingerPrint);
                } else {
                    isLucky = isLuckyNumber(digits);
                    solution.put(fingerPrint, isLucky);
                }
                if (isLucky) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private boolean isLuckyNumber(List<Integer> digits) {
        return isPrime(digitsSum(digits)) && isPrime(digitsSquareSum(digits));
    }

    private List<Integer> digits(long number) {
        List<Integer> digits = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        long remain = number;
        while (remain >= 10) {
            int mod = (int) (remain % 10);
            digits.set(mod, digits.get(mod) + 1);
            remain = (remain - mod) / 10;
        }
        digits.set((int) remain, digits.get((int) remain) + 1);
        return digits;
    }

    private long fingerPrint(List<Integer> digits) {
        long fingerPrint = 0;
        for (int i = 1; i < 10; i++) {
            fingerPrint = fingerPrint * 10 + digits.get(i);
        }
        return fingerPrint;
    }

    private int digitsSum(List<Integer> digits) {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += i * digits.get(i);
        }
        return sum;
    }

    private int digitsSquareSum(List<Integer> digits) {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += squares[i - 1] * digits.get(i);
        }
        return sum;
    }

    private boolean isPrime(int sum) {
        return primes.contains(sum);
    }

    private void getInput() {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        startNumbers = new long[T];
        endNumbers = new long[T];
        for (int i = 0; i < T; i++) {
            startNumbers[i] = scanner.nextLong();
            endNumbers[i] = scanner.nextLong();
        }
    }

    private static final int[] squares = new int[] { 1, 4, 9, 16, 25, 36, 49,
            64, 81 };

    private static final Set<Integer> primes = new HashSet<Integer>(
            Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                    47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107,
                    109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
                    179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239,
                    241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311,
                    313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383,
                    389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457,
                    461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
                    547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613,
                    617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683,
                    691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769,
                    773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857,
                    859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
                    947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019,
                    1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087,
                    1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153,
                    1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229,
                    1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297,
                    1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381,
                    1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453,
                    1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523,
                    1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597,
                    1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663,
                    1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733, 1741,
                    1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823,
                    1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889, 1901,
                    1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 1993,
                    1997, 1999));
}