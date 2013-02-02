package com.niyue.coding.interviewstreet.luckynumbers;

import java.util.*;

public class Solution {

    private int T;
    private long[] startNumbers;
    private long[] endNumbers;
    private static final int MAX_NUMBER_OF_DIGITS = 18;
    private FingerPrintStore naturalFingerPrints = new FingerPrintStore(9 * MAX_NUMBER_OF_DIGITS, MAX_NUMBER_OF_DIGITS);
    private FingerPrintStore squareFingerPrints = new FingerPrintStore(9 * 9 * MAX_NUMBER_OF_DIGITS, MAX_NUMBER_OF_DIGITS);
    private static final int[] NATURAL_NUMBERS = new int[]{0, 1, 2, 3, 4,  5,  6,  7,  8,  9 };
    private static final int[] SQUARED_NUMBERS = new int[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81};

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        getInput();

        List<int[]> luckyNumberFingerPrints = generateAllLuckyNumberFingerPrints(MAX_NUMBER_OF_DIGITS);

        for (int i = 0; i < T; i++) {
            long start = startNumbers[i];
            long end = endNumbers[i];
            long count = 0;
            for(int[] luckyDigits : luckyNumberFingerPrints) {
                long startRank = rank(luckyDigits, start, MAX_NUMBER_OF_DIGITS);
                long endRank = rank(luckyDigits, end, MAX_NUMBER_OF_DIGITS);
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
     * @param luckyDigits the digits for a lucky number finger print
     * @param number the number given to be ranked
     * @return the rank for the given number in the numbers derived from the given finger print
     */
    long rank(int[] luckyDigits, long number, int maxNumberOfDigits) {
        List<Integer> numberDigits = splitDigits(number, maxNumberOfDigits);
        return rank(luckyDigits, numberDigits, 0, maxNumberOfDigits);
    }

    long rank(int[] digits, List<Integer> number, int startIndex, int totalNumberOfDigits) {
        long rank = 0;
        if(startIndex < number.size()) {
            int digit = number.get(startIndex);

            for(int i = 0;i < digit;i++) {
                if(digits[i] > 0) {
                    decreaseDigitCount(digits, i);
                    long rankForI = combinations(digits, totalNumberOfDigits - 1);
                    rank += rankForI;
                    increaseDigitCount(digits, i);
                }
            }

            if(digits[digit] > 0) {
                decreaseDigitCount(digits, digit);
                long subRank = rank(digits, number, startIndex + 1, totalNumberOfDigits - 1);
                rank += subRank;
                increaseDigitCount(digits, digit);
            }
        }
        return rank;
    }

    long combinations(final int[] digits, int totalNumberOfDigits) {
        long combination = FACTORIALS[totalNumberOfDigits];
        for (int digit : digits) {
            combination /= FACTORIALS[digit];
        }
        return combination;
    }

    private List<Integer> splitDigits(long number, int length) {
        List<Integer> digits = new ArrayList<Integer>();
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

    private void decreaseDigitCount(int[] fingerPrintDigits, int digit) {
        fingerPrintDigits[digit] = fingerPrintDigits[digit] - 1;
    }

    private void increaseDigitCount(int[] fingerPrintDigits, int digit) {
        fingerPrintDigits[digit] = fingerPrintDigits[digit] + 1;
    }

    List<int[]> generateAllLuckyNumberFingerPrints(int maxNumberOfDigits) {
        SortedSet<Integer> primesUnderMaxSum = PRIMES.headSet(9 * 9 * maxNumberOfDigits);
        List<int[]> luckyNumberFingerPrints = new LinkedList<int[]>();
        for(int prime : primesUnderMaxSum) {
            List<FingerPrint> fingerPrintsForPrime = validSquareFingerPrints(prime, 9, maxNumberOfDigits);
            for(FingerPrint fingerPrint : fingerPrintsForPrime) {
                int[] digits = fingerPrint.getDigits();

                int sum = digitsSum(digits);
                if(isPrime(sum)) {
                    luckyNumberFingerPrints.add(digits);
                }
            }
        }
        return luckyNumberFingerPrints;
    }

    // there are totally remainingNumberOfDigits, and max digit allowed is startingDigit, generate all finger prints that sums to the given sum
    List<FingerPrint> validFingerPrints(int sum, int startingDigit, int remainingNumberOfDigits) {
        preFillZeroSumResult(naturalFingerPrints, remainingNumberOfDigits);

        return validFingerPrints(sum, startingDigit, remainingNumberOfDigits, NATURAL_NUMBERS, naturalFingerPrints);
    }

    List<FingerPrint> validSquareFingerPrints(int sum, int startingDigit, int remainingNumberOfDigits) {
        preFillZeroSumResult(squareFingerPrints, remainingNumberOfDigits);
        return validFingerPrints(sum, startingDigit, remainingNumberOfDigits, SQUARED_NUMBERS, squareFingerPrints);
    }

    private void preFillZeroSumResult(FingerPrintStore fingerPrintStore, int maxNumberOfDigits) {
        for(int i=0;i < 10;i++) {
            for(int j = 0;j <= maxNumberOfDigits;j++) {
                int[] digits = new int[i + 1];
                digits[0] = j;
                FingerPrint allZeroFingerPrint = new FingerPrint(digits);
                fingerPrintStore.put(0, i, j, Collections.singletonList(allZeroFingerPrint));
            }
        }
    }

    private List<FingerPrint> validFingerPrints(int sum, int startingDigit, int remainingNumberOfDigits, int[] mappedNumbers, FingerPrintStore fingerPrintStore) {
        List<FingerPrint> fingerPrints = fingerPrintStore.get(sum, startingDigit, remainingNumberOfDigits);

        if(fingerPrints == null) {
            if(startingDigit > 0) {
                fingerPrints = new LinkedList<FingerPrint>();
                int mappedNumber = mappedNumbers[startingDigit];
                int maxTimes = sum / mappedNumber;
                if(maxTimes <= remainingNumberOfDigits) {
                    for(int j = maxTimes;j >= 0;j--) {
                        List<FingerPrint> subFingerPrints = validFingerPrints(sum - mappedNumber * j, startingDigit - 1, remainingNumberOfDigits - j, mappedNumbers, fingerPrintStore);
                        for(FingerPrint subFingerPrint : subFingerPrints) {
                            fingerPrints.add(new FingerPrint(subFingerPrint, j));
                        }
                    }
                }
            } else {
                fingerPrints = Collections.emptyList();
            }
            fingerPrintStore.put(sum, startingDigit, remainingNumberOfDigits, fingerPrints);
        }
        return fingerPrints;
    }

    private int digitsSum(int[] digits) {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += i * digits[i];
        }
        return sum;
    }

    private int digitsSquareSum(int[] digits) {
        int sum = 0;
        for (int i = 1; i < 10; i++) {
            sum += SQUARED_NUMBERS[i] * digits[i];
        }
        return sum;
    }

    private boolean isPrime(int sum) {
        return PRIME_SET.contains(sum);
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
        public final FingerPrint extendFrom;
        public final int numberOfDigits;
        public final int digit;

        public FingerPrint(FingerPrint extendFrom, int numberOfTimes) {
            this.extendFrom = extendFrom;
            this.numberOfDigits = numberOfTimes;
            this.digit = extendFrom.digit + 1;
        }

        public FingerPrint(int... digits) {
            this.digit = digits.length - 1;
            this.numberOfDigits = digits[digits.length - 1];
            if(digits.length > 1) {
                this.extendFrom = new FingerPrint(Arrays.copyOf(digits, digits.length - 1));
            } else {
                this.extendFrom = null;
            }
        }

        public int[] getDigits() {
            int[] digits = new int[digit + 1];

            for(FingerPrint current = this;current != null;current = current.extendFrom) {
                digits[current.digit] = current.numberOfDigits;
            }

            return digits;
        }

        @Override
        public String toString() {
            int[] digits = getDigits();
            StringBuilder string = new StringBuilder();
            for(Integer digit : digits) {
                string.append(digit).append(" ");
            }
            return string.toString().trim();
        }
    }

    private static class FingerPrintStore {
        private final List<FingerPrint>[][][] store;
        public FingerPrintStore(int maxSum, int maxNumberOfDigits) {
            store = new List[maxSum+1][10][maxNumberOfDigits+1];
        }

        public void put(int sum, int startingDigit, int remainingNumberOfDigits, List<FingerPrint> fingerPrints) {
            store[sum][startingDigit][remainingNumberOfDigits] = fingerPrints;
        }

        public List<FingerPrint> get(int sum, int startingDigit, int remainingNumberOfDigits) {
            return store[sum][startingDigit][remainingNumberOfDigits];
        }
    }

    private static final long[] FACTORIALS = new long[] {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600,
            6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L};

    private static final SortedSet<Integer> PRIMES = new TreeSet<Integer>(
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

    private static final Set<Integer> PRIME_SET = new HashSet<Integer>(PRIMES);
}