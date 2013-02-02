package com.niyue.coding.interviewstreet.luckynumbers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class LuckyNumbersTest {

    @Test
    public void testGenerateFingerPrintsForZeroStartingFromOne() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(0, 1, 2);
        assertEquals(1, fingerPrints.size());
        assertEquals("2 0", fingerPrints.iterator().next().toString());
    }

    @Test
    public void testGenerateFingerPrintsForZeroStartingFromNine() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(0, 9, 2);
        assertEquals(1, fingerPrints.size());
        assertEquals("2 0 0 0 0 0 0 0 0 0", fingerPrints.iterator().next().toString());
    }

    @Test
    public void testGenerateFingerPrintsForOneRemainingDigitsStartingFromNine() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(3, 9, 1);
        assertEquals(1, fingerPrints.size());
        assertEquals("0 0 0 1 0 0 0 0 0 0", fingerPrints.iterator().next().toString());
    }

    @Test
    public void testGenerateFingerPrintsForThreeWithTwoRemainingDigitsStartingFromNine() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(3, 9, 2);
        assertFingerPrintSetEquals(fingerPrints, "1 0 0 1 0 0 0 0 0 0", "0 1 1 0 0 0 0 0 0 0");
    }

    @Test
    public void testGenerateFingerPrintsForThreeWithThreeRemainingDigitsFromNine() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(3, 9, 3);
        assertFingerPrintSetEquals(fingerPrints, "2 0 0 1 0 0 0 0 0 0", "1 1 1 0 0 0 0 0 0 0", "0 3 0 0 0 0 0 0 0 0");
    }

    @Test
    public void testGenerateFingerPrintsFor322() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(3, 2, 2);
        assertFingerPrintSetEquals(fingerPrints, "0 1 1");
    }

    @Test
    public void testGenerateFingerPrintsFor412() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(4, 1, 2);
        assertFingerPrintSetEquals(fingerPrints, new String[] {});
    }

    @Test
    public void testGenerateFingerPrintsFor211() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(2, 1, 1);
        assertFingerPrintSetEquals(fingerPrints, new String[] {});
    }

    @Test
    public void testGenerateFingerPrintsFor422() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(4, 2, 2);
        assertFingerPrintSetEquals(fingerPrints, "0 0 2");
    }

    @Test
    public void testGenerateFingerPrintsFor111() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(1, 1, 1);
        assertFingerPrintSetEquals(fingerPrints, "0 1");
    }

    @Test
    public void testGenerateFingerPrintsFor121() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(1, 2, 1);
        assertFingerPrintSetEquals(fingerPrints, "0 1 0");
    }

    @Test
    public void testGenerateFingerPrintsFor432() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(4, 3, 2);
        assertFingerPrintSetEquals(fingerPrints, "0 1 0 1", "0 0 2 0");
    }

    @Test
    public void testGenerateFingerPrintsFor492() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(4, 9, 2);
        assertFingerPrintSetEquals(fingerPrints, "1 0 0 0 1 0 0 0 0 0", "0 1 0 1 0 0 0 0 0 0", "0 0 2 0 0 0 0 0 0 0");
    }

    @Test
    public void testGenerateFingerPrintsFor89() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(89, 9, 18);
        assertTrue(fingerPrints.size() > 0);
    }

    @Test
    public void testGenerateFingerPrintsFor162() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(162, 9, 18);
        assertFingerPrintSetEquals(fingerPrints, "0 0 0 0 0 0 0 0 0 18");
    }

    @Test
    public void testGenerateFingerPrintsForSquareZeroStartingFromNine() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validSquareFingerPrints(0, 9, 2);
        assertFingerPrintSetEquals(fingerPrints, "2 0 0 0 0 0 0 0 0 0");
    }

    @Test
    public void testGenerateFingerPrintsForSquare191() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validSquareFingerPrints(1, 9, 1);
        assertFingerPrintSetEquals(fingerPrints, "0 1 0 0 0 0 0 0 0 0");
    }

    @Test
    public void testGenerateFingerPrintsForSquare222() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validSquareFingerPrints(2, 2, 2);
        assertFingerPrintSetEquals(fingerPrints, "0 2 0");
    }

    @Test
    public void testFingerPrintToString() {
        Solution.FingerPrint finterPrint = new Solution.FingerPrint(0, 2, 0);
        assertEquals(2, finterPrint.digit);
        assertEquals("0 2 0", finterPrint.toString());
        Solution.FingerPrint extendedFingerPrint = new Solution.FingerPrint(finterPrint, 0);
        assertEquals(3, extendedFingerPrint.digit);
        assertEquals("0 2 0 0", extendedFingerPrint.toString());
    }


    @Test
    public void testGenerateFingerPrintsForSquare232() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validSquareFingerPrints(2, 3, 2);
        assertFingerPrintSetEquals(fingerPrints, "0 2 0 0");
    }

    @Test
    public void testGenerateFingerPrintsForSquare592() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validSquareFingerPrints(5, 9, 2);
        assertFingerPrintSetEquals(fingerPrints, "0 1 1 0 0 0 0 0 0 0");
    }

    @Test
    public void testGenerateFingerPrintsForSquare600() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> squareFingerPrints = solution.validSquareFingerPrints(600, 9, 18);
        assertTrue(squareFingerPrints.size() > 0);
    }

    @Test
    public void testGenerateAllValidFingerPrints() {
        Solution solution = new Solution();
        List<int[]> validFingerPrints = solution.generateAllLuckyNumberFingerPrints(1);
        assertEquals(0, validFingerPrints.size());
    }

    @Test
    public void testGenerateAllValidFingerPrintsTwoDigits() {
        Solution solution = new Solution();
        List<int[]> validFingerPrints = solution.generateAllLuckyNumberFingerPrints(2);
        assertTrue(validFingerPrints.size() > 0);
        assertEquals(10, validFingerPrints.size());
    }

    @Test
    public void testGenerateAllValidFingerPrints15Digits() {
        Solution solution = new Solution();
        List<int[]> validFingerPrints = solution.generateAllLuckyNumberFingerPrints(15);
        assertTrue(validFingerPrints.size() > 0);
    }

    @Test
    public void testCombinationFor0() {
        Solution solution = new Solution();
        long combination = solution.combinations(new int[]{1}, 1);
        assertEquals(1, combination);
    }

    @Test
    public void testCombinationForTwoZeros() {
        Solution solution = new Solution();
        long combination = solution.combinations(new int[]{2}, 2);
        assertEquals(1, combination);
    }

    @Test
    public void testCombinationForOneZeroOneOne() {
        Solution solution = new Solution();
        long combination = solution.combinations(new int[]{1, 1}, 2);
        assertEquals(2, combination);
    }

    @Test
    public void testCombinationForOneZeroTwoOnes() {
        Solution solution = new Solution();
        long combination = solution.combinations(new int[]{1, 2}, 3);
        assertEquals(3, combination);
    }

    @Test
    public void testCombinationForTwoZerosTwoOnes() {
        Solution solution = new Solution();
        long combination = solution.combinations(new int[]{2, 2}, 4);
        assertEquals(6, combination);
    }

    @Test
    public void testCombinationForThreeZerosTwoOnes() {
        Solution solution = new Solution();
        long combination = solution.combinations(new int[]{3, 2}, 5);
        assertEquals(10, combination);
    }

    @Test
    public void testCombinationForOneZeroTwoOnesOneTwo() {
        Solution solution = new Solution();
        long combination = solution.combinations(new int[]{1, 2, 1}, 4);
        assertEquals(12, combination);
    }

    @Test
    public void testRank() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{1, 2, 1}, new int[] {1, 1, 2, 0}, 4);
        assertEquals(6, rank);
    }

    @Test
    public void testRank1121() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{1, 2, 1}, new int[] {1, 1, 2, 1}, 4);
        assertEquals(7, rank);
    }

    @Test
    public void testRank1210() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{1, 2, 1}, new int[] {1, 2, 1, 0}, 4);
        assertEquals(8, rank);
    }

    @Test
    public void testRank0112() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{1, 2, 1}, new int[] {0, 1, 1, 2}, 4);
        assertEquals(0, rank);
    }

    @Test
    public void testRank2011() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{1, 2, 1}, new int[] {2, 0, 1, 1}, 4);
        assertEquals(9, rank);
    }

    @Test
    public void testRank2110() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{1, 2, 1}, new int[] {2, 1, 1, 0}, 4);
        assertEquals(11, rank);
    }

    @Test
    public void testRank2222() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{1, 2, 1}, new int[] {2, 2, 2, 2}, 4);
        assertEquals(12, rank);
    }

    @Test
    public void testSimpleRank() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{1, 2}, new int[] {1, 1, 0}, 3);
        assertEquals(2, rank);
    }

    @Test
    public void testRankWithOneDigit() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{1}, new int[] {0}, 1);
        assertEquals(0, rank);
    }

    @Test
    public void testRankWith01() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{1, 1}, new int[] {0, 1}, 2);
        assertEquals(0, rank);
    }

    @Test
    public void testRankWith10() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{1, 1}, new int[] {1, 0}, 2);
        assertEquals(1, rank);
    }

    @Test
    public void testRankWith01001() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{3, 2}, new int[] {0, 1, 0, 0, 1}, 5);
        assertEquals(3, rank);
    }

    @Test
    public void testRankWith11000() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{3, 2}, new int[] {1, 1, 0, 0, 0}, 5);
        assertEquals(9, rank);
    }

    @Test
    public void testRankWith10010() {
        Solution solution = new Solution();
        long rank = solution.rank(new int[]{3, 2}, new int[] {1, 0, 0, 1, 0}, 5);
        assertEquals(7, rank);
    }

    @Test
    public void testFingerPrintDigits() {
        Solution.FingerPrint fingerPrint = new Solution.FingerPrint(2, 3);
        assertEquals(1, fingerPrint.digit);
        assertEquals(3, fingerPrint.numberOfDigits);
        assertEquals(0, fingerPrint.extendFrom.digit);
        assertEquals(2, fingerPrint.extendFrom.numberOfDigits);
//        assertEquals(3, fingerPrint.sum());
//        assertEquals(3, fingerPrint.squareSum());
        assertNull(fingerPrint.extendFrom.extendFrom);
    }

    private void assertFingerPrintSetEquals(List<Solution.FingerPrint> fingerPrints, String... fingerPrintStrings) {
        assertEquals(fingerPrintStrings.length, fingerPrints.size());
        Set<String> actualFingerPrintStrings = new HashSet<String>();
        for(Solution.FingerPrint fingerPrint : fingerPrints) {
            actualFingerPrintStrings.add(fingerPrint.toString());
        }
        for(String fingerPrintString : fingerPrintStrings) {
            assertTrue(actualFingerPrintStrings.contains(fingerPrintString));
        }
    }
}
