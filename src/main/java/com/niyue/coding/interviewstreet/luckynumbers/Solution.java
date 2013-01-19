package com.niyue.coding.interviewstreet.luckynumbers;

import java.util.*;

public class Solution {

    private int T;
    private long[] startNumbers;
    private long[] endNumbers;
    private Map<Long, Boolean> solution = new HashMap<Long, Boolean>();
    private Map<Integer, Map<Integer, Set<FingerPrint>>> fingerPrintDB = new HashMap<Integer, Map<Integer, Set<FingerPrint>>>();
    private Map<String, List<FingerPrint>> naturalFingerPrints = new HashMap<String, List<FingerPrint>>();
    private Map<String, List<FingerPrint>> squareFingerPrints = new HashMap<String, List<FingerPrint>>();
    private List<Integer> NATURAL_NUMBERS = Arrays.asList(0, 1, 2, 3, 4,  5,  6,  7,  8,  9 );
    private List<Integer> SQUARED_NUMBERS = Arrays.asList(0, 1, 4, 9, 16, 25, 36, 49, 64, 81);

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        getInput();

        List<FingerPrint> luckyNumberFingerPrints = generateAllLuckyNumberFingerPrints();

        for (int i = 0; i < T; i++) {
            long start = startNumbers[i];
            long end = endNumbers[i];
            long count = 0;
            for(FingerPrint fingerPrint : luckyNumberFingerPrints) {
                long startRank = rank(fingerPrint, start);
                long endRank = rank(fingerPrint, end);
                count += endRank - startRank;
            }
            System.out.println(count);
        }
    }

    /**
     * Compute the rank for a number when a finger print is given
     * For any given finger print, many numbers can be derived from this finger print.
     * For example, a finger print (0, 2, 1) means there are zero "0", two "1" and one "2" in this finger print, and there are three numbers that can derived from it, including: 112, 121, 211
     * The rank means the given number's order in the set of numbers derived from this finger print when they are compared numerically
     * For example, a number 199 will rank #3 in the example above since it is larger than 112 and 121 but smaller than 211
     * @param fingerPrint the FingerPrint given
     * @param number the number given to be ranked
     * @return the rank for the given number in the numbers derived from the given finger print
     */
    long rank(FingerPrint fingerPrint, long number) {
        List<Integer> nextGreaterNumber = nextGreaterNumber(fingerPrint, number, fingerPrint.digits.size());
        return 0;
    }

    private List<Integer> digits(long number, int length) {
        List<Integer> digits = new ArrayList();
        long remain = number;
        while (remain >= 10) {
            int mod = (int) (remain % 10);
            digits.add(mod);
            remain = (remain - mod) / 10;
        }
        digits.add((int) remain);
        for(int i = digits.size();i < length;i++) {
            digits.add(0);
        }
        Collections.reverse(digits);
        return digits;
    }

    // find the a minimum number that is greater than the given number from all numbers generated from the given finger print
    List<Integer> nextGreaterNumber(FingerPrint fingerPrint, long number, int length) {
        List<Integer> digits = digits(number, length);
        List<Integer> fingerPrintDigits = fullDigits(fingerPrint);
        return findNextGreaterNumber(digits, fingerPrintDigits);
    }

    // for example, digits: [1, 9, 9], fingerPrintDigits: [0, 2, 1]
    // output should be [2, 0, 1]
    List<Integer> findNextGreaterNumber(List<Integer> digits, List<Integer> fingerPrintDigits) {
        int[] states = new int[digits.size()];
        LinkedList<Integer> nextGreaterNumber = new LinkedList<Integer>();
        for(int i = 0;i < digits.size() && i >= 0;) {
            if(states[i] == 0) {
                if(hasEqualDigit(digits.get(i), fingerPrintDigits)) {
                    states[i] = 1;
                    nextGreaterNumber.add(digits.get(i));
                    decreaseDigitCount(fingerPrintDigits, digits.get(i));
                    i++;
                } else {
                    i = greaterNumberState(digits, fingerPrintDigits, nextGreaterNumber, states, i);
                }
            } else if(states[i] == 1) {
                i = greaterNumberState(digits, fingerPrintDigits, nextGreaterNumber, states, i);
            }
        }
        return nextGreaterNumber;
    }

    private int greaterNumberState(List<Integer> digits, List<Integer> fingerPrintDigits, LinkedList<Integer> nextGreaterNumber, int[] states, int currentDigitIndex) {
        int firstGreaterNumber = firstGreaterDigit(digits.get(currentDigitIndex), fingerPrintDigits);
        if(firstGreaterNumber != -1) {
            nextGreaterNumber.add(firstGreaterNumber);
            decreaseDigitCount(fingerPrintDigits, firstGreaterNumber);
            addMinimumNumber(nextGreaterNumber, fingerPrintDigits);
            currentDigitIndex = digits.size();
        } else {
            if(currentDigitIndex > 0) {
                states[currentDigitIndex] = 0;
                int digit = nextGreaterNumber.removeLast();
                increaseDigitCount(fingerPrintDigits, digit);
            }
            currentDigitIndex--;
        }
        return currentDigitIndex;
    }

    List<Integer> addMinimumNumber(List<Integer> nextGreaterNumber, List<Integer> fingerPrintDigits) {
        for(int i=0;i < fingerPrintDigits.size();i++) {
            for(int j=0;j < fingerPrintDigits.get(i);j++) {
                nextGreaterNumber.add(i);
            }
        }
        return nextGreaterNumber;
    }

    private void decreaseDigitCount(List<Integer> fingerPrintDigits, int digit) {
        fingerPrintDigits.set(digit, fingerPrintDigits.get(digit) - 1);
    }

    private void increaseDigitCount(List<Integer> fingerPrintDigits, int digit) {
        fingerPrintDigits.set(digit, fingerPrintDigits.get(digit) + 1);
    }


    private boolean hasEqualDigit(int digit, List<Integer> fingerPrintDigits) {
        return fingerPrintDigits.get(digit) > 0;
    }

    int firstGreaterDigit(int digit, List<Integer> fingerPrintDigits) {
        int first = -1;
        for(int i = digit + 1;i < fingerPrintDigits.size();i++) {
            if(fingerPrintDigits.get(i) > 0) {
                first = i;
            }
        }
        return first;
    }

    private List<Integer> fullDigits(FingerPrint fingerPrint) {
        List<Integer> fingerPrintDigits = fingerPrint.getDigits();
        List<Integer> digits = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        for(int i = 0;i < fingerPrintDigits.size();i++) {
            digits.set(i, fingerPrintDigits.get(i));
        }
        return digits;
    }

    List<FingerPrint> generateAllLuckyNumberFingerPrints() {
        int MAX_DIGITS = 18;
        SortedSet<Integer> primesUnderMaxSum = primes.headSet(9 * 9 * MAX_DIGITS);
        List<FingerPrint> luckyNumberFingerPrints = new LinkedList<FingerPrint>();
        for(int prime : primesUnderMaxSum) {
            List<FingerPrint> fingerPrintsForPrime = validSquareFingerPrints(prime, 9, MAX_DIGITS);
            for(FingerPrint fingerPrint : fingerPrintsForPrime) {
                int sum = digitsSum(fingerPrint.getDigits());
                if(isPrime(sum)) { // a lucky number finger print
                    luckyNumberFingerPrints.add(fingerPrint);
                }
            }
        }
        return luckyNumberFingerPrints;
    }

    // there are totally remainingNumberOfDigits, and max digit allowed is startingDigit, generate all finger prints that sums to the given sum
    List<FingerPrint> validFingerPrints(int sum, int startingDigit, int remainingNumberOfDigits) {
        return validFingerPrints(sum, startingDigit, remainingNumberOfDigits, NATURAL_NUMBERS, naturalFingerPrints);
    }

    List<FingerPrint> validSquareFingerPrints(int sum, int startingDigit, int remainingNumberOfDigits) {
        return validFingerPrints(sum, startingDigit, remainingNumberOfDigits, SQUARED_NUMBERS, squareFingerPrints);
    }

    private List<FingerPrint> validFingerPrints(int sum, int startingDigit, int remainingNumberOfDigits, List<Integer> mappedNumbers, Map<String, List<FingerPrint>> fingerPrintStore) {
        List<FingerPrint> fingerPrints = null;
        String key = fingerPrintKey(sum, startingDigit, remainingNumberOfDigits);
        if(fingerPrintStore.containsKey(key)) {
            fingerPrints = fingerPrintStore.get(key);
        } else {
            fingerPrints = new LinkedList<FingerPrint>();
            if(startingDigit > 0 || sum == 0) {
                if(sum == 0) {
                    FingerPrint allZeroFingerPrint = new FingerPrint(startingDigit, remainingNumberOfDigits);
                    fingerPrints.add(allZeroFingerPrint);
                } else {
                    int mappedNumber = mappedNumbers.get(startingDigit);
                    int maxTimes = sum < mappedNumber ? 0 : sum / mappedNumber;
                    if(maxTimes <= remainingNumberOfDigits) {
                        for(int j = maxTimes;j >= 0;j--) {
                            List<FingerPrint> subFingerPrints = validFingerPrints(sum - mappedNumber * j, startingDigit - 1, remainingNumberOfDigits - j, mappedNumbers, fingerPrintStore);
                            for(FingerPrint subFingerPrint : subFingerPrints) {
                                fingerPrints.add(subFingerPrint.newSet(startingDigit, j));
                            }
                        }
                    }
                }
            }
            fingerPrintStore.put(key, fingerPrints);
        }
        return fingerPrints;
    }

    private String fingerPrintKey(int sum, int startingDigit, int remainingNumberOfDigits) {
        return String.format("%d %d %d", sum, startingDigit, remainingNumberOfDigits);
    }

    private int digitsSum(List<Integer> digits) {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += i * digits.get(i);
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

    public static final class FingerPrint {
        private final int startingDigit;
        private List<Integer> digits;

        public FingerPrint(int startingDigit, int numberOfZero) {
            this.startingDigit = startingDigit;
            this.digits = new ArrayList<Integer>(startingDigit + 1);
            digits.add(numberOfZero);
            for(int i=1;i<startingDigit + 1;i++) {
                digits.add(0);
            }
        }

        public FingerPrint(List<Integer> currentDigits, int numberOfTimes) {
            this.startingDigit = currentDigits.size() - 1;
            digits = new ArrayList<Integer>(currentDigits.size() + 1);
            for(int i=0;i<currentDigits.size();i++) {
                digits.add(currentDigits.get(i));
            }
            digits.add(numberOfTimes);
        }

        public FingerPrint(Integer... digits) {
            this.startingDigit = 0;
            this.digits = Arrays.asList(digits);
        }

        public List<Integer> getDigits() {
            return digits;
        }

        public FingerPrint newSet(int digit, int numberOfTimes) {
            return new FingerPrint(digits, numberOfTimes);
        }

        @Override
        public String toString() {
            StringBuilder string = new StringBuilder();
            for(Integer digit : digits) {
                string.append(digit).append(" ");
            }
            return string.toString();
        }
    }

    private static final int[] squares = new int[] { 1, 4, 9, 16, 25, 36, 49, 64, 81 };

    private static final SortedSet<Integer> primes = new TreeSet<Integer>(
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
                    1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453));
}