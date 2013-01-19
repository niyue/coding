package com.niyue.coding.interviewstreet.luckynumbers;

import org.junit.Ignore;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LuckyNumbersTest {

    @Test
    public void testGenerateFingerPrintsForZeroStartingFromOne() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(0, 1, 2);
        assertEquals(1, fingerPrints.size());
        assertEquals("2 0 ", fingerPrints.iterator().next().toString());
    }

    @Test
    public void testGenerateFingerPrintsForZeroStartingFromNine() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(0, 9, 2);
        assertEquals(1, fingerPrints.size());
        assertEquals("2 0 0 0 0 0 0 0 0 0 ", fingerPrints.iterator().next().toString());
    }

    @Test
    public void testGenerateFingerPrintsForOneRemainingDigitsStartingFromNine() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(3, 9, 1);
        assertEquals(1, fingerPrints.size());
        assertEquals("0 0 0 1 0 0 0 0 0 0 ", fingerPrints.iterator().next().toString());
    }

    @Test
    public void testGenerateFingerPrintsForThreeWithTwoRemainingDigitsStartingFromNine() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(3, 9, 2);
        assertFingerPrintSetEquals(fingerPrints, "1 0 0 1 0 0 0 0 0 0 ", "0 1 1 0 0 0 0 0 0 0 ");
    }

    @Test
    public void testGenerateFingerPrintsForThreeWithThreeRemainingDigitsFromNine() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(3, 9, 3);
        assertFingerPrintSetEquals(fingerPrints, "2 0 0 1 0 0 0 0 0 0 ", "1 1 1 0 0 0 0 0 0 0 ", "0 3 0 0 0 0 0 0 0 0 ");
    }

    @Test
    public void testGenerateFingerPrintsFor322() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(3, 2, 2);
        assertFingerPrintSetEquals(fingerPrints, "0 1 1 ");
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
        assertFingerPrintSetEquals(fingerPrints, "0 0 2 ");
    }

    @Test
    public void testGenerateFingerPrintsFor111() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(1, 1, 1);
        assertFingerPrintSetEquals(fingerPrints, "0 1 ");
    }

    @Test
    public void testGenerateFingerPrintsFor121() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(1, 2, 1);
        assertFingerPrintSetEquals(fingerPrints, "0 1 0 ");
    }

    @Test
    public void testGenerateFingerPrintsFor432() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(4, 3, 2);
        assertFingerPrintSetEquals(fingerPrints, "0 1 0 1 ", "0 0 2 0 ");
    }

    @Test
    public void testGenerateFingerPrintsFor492() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validFingerPrints(4, 9, 2);
        assertFingerPrintSetEquals(fingerPrints, "1 0 0 0 1 0 0 0 0 0 ", "0 1 0 1 0 0 0 0 0 0 ", "0 0 2 0 0 0 0 0 0 0 ");
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
        assertFingerPrintSetEquals(fingerPrints, "0 0 0 0 0 0 0 0 0 18 ");
    }

    @Test
    public void testGenerateFingerPrintsForSquareZeroStartingFromNine() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validSquareFingerPrints(0, 9, 2);
        assertFingerPrintSetEquals(fingerPrints, "2 0 0 0 0 0 0 0 0 0 ");
    }

    @Test
    public void testGenerateFingerPrintsForSquare191() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validSquareFingerPrints(1, 9, 1);
        assertFingerPrintSetEquals(fingerPrints, "0 1 0 0 0 0 0 0 0 0 ");
    }

    @Test
    public void testGenerateFingerPrintsForSquare222() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validSquareFingerPrints(2, 2, 2);
        assertFingerPrintSetEquals(fingerPrints, "0 2 0 ");
    }

    @Test
    public void testGenerateFingerPrintsForSquare232() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validSquareFingerPrints(2, 3, 2);
        assertFingerPrintSetEquals(fingerPrints, "0 2 0 0 ");
    }

    @Test
    public void testGenerateFingerPrintsForSquare592() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> fingerPrints = solution.validSquareFingerPrints(5, 9, 2);
        assertFingerPrintSetEquals(fingerPrints, "0 1 1 0 0 0 0 0 0 0 ");
    }

    @Test
    public void testGenerateFingerPrintsForSquare600() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> squareFingerPrints = solution.validSquareFingerPrints(600, 9, 18);
        assertTrue(squareFingerPrints.size() > 0);
    }

    @Test
    @Ignore
    public void testGenerateAllValidFingerPrints() {
        Solution solution = new Solution();
        List<Solution.FingerPrint> validFingerPrints = solution.generateAllLuckyNumberFingerPrints();
        System.out.println(validFingerPrints.size());
    }

    @Test
    public void testFirstGreaterDigit() {
        Solution solution = new Solution();
        int firstGreaterDigit = solution.firstGreaterDigit(1, Arrays.asList(1, 1, 1));
        assertEquals(2, firstGreaterDigit);
    }

    @Test
    public void testNoFirstGreaterDigit() {
        Solution solution = new Solution();
        int firstGreaterDigit = solution.firstGreaterDigit(5, Arrays.asList(1, 1, 1));
        assertEquals(-1, firstGreaterDigit);
    }

    @Test
    public void testCombinationFor0() {
        Solution solution = new Solution();
        long combination = solution.combinations(Arrays.asList(1));
        assertEquals(1, combination);
    }

    @Test
    public void testCombinationForTwoZeros() {
        Solution solution = new Solution();
        long combination = solution.combinations(Arrays.asList(2));
        assertEquals(1, combination);
    }

    @Test
    public void testCombinationForOneZeroOneOne() {
        Solution solution = new Solution();
        long combination = solution.combinations(Arrays.asList(1, 1));
        assertEquals(2, combination);
    }

    @Test
    public void testCombinationForOneZeroTwoOnes() {
        Solution solution = new Solution();
        long combination = solution.combinations(Arrays.asList(1, 2));
        assertEquals(3, combination);
    }

    @Test
    public void testCombinationForTwoZerosTwoOnes() {
        Solution solution = new Solution();
        long combination = solution.combinations(Arrays.asList(2, 2));
        assertEquals(6, combination);
    }

    @Test
    public void testCombinationForThreeZerosTwoOnes() {
        Solution solution = new Solution();
        long combination = solution.combinations(Arrays.asList(3, 2));
        assertEquals(10, combination);
    }

    @Test
    public void testCombinationForOneZeroTwoOnesOneTwo() {
        Solution solution = new Solution();
        long combination = solution.combinations(Arrays.asList(1, 2, 1));
        assertEquals(12, combination);
    }

    @Test
    public void testRank() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(1, 2, 1), 1120);
        assertEquals(6, rank);
    }

    @Test
    public void testRank1121() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(1, 2, 1), 1121);
        assertEquals(7, rank);
    }

    @Test
    public void testRank1210() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(1, 2, 1), 1210);
        assertEquals(8, rank);
    }

    @Test
    public void testRank0112() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(1, 2, 1), 0112);
        assertEquals(0, rank);
    }

    @Test
    public void testRank2011() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(1, 2, 1), 2011);
        assertEquals(9, rank);
    }

    @Test
    public void testRank2110() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(1, 2, 1), 2110);
        assertEquals(11, rank);
    }

    @Test
    public void testRank9999() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(1, 2, 1), 2222);
        assertEquals(12, rank);
    }

    @Test
    public void testSimpleRank() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(new Integer[]{1, 2}), 110);
        assertEquals(2, rank);
    }

    @Test
    public void testRankWithOneDigit() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(1), 0);
        assertEquals(0, rank);
    }

    @Test
    public void testRankWith01() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(new Integer[]{1, 1}), 01);
        assertEquals(0, rank);
    }

    @Test
    public void testRankWith10() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(new Integer[]{1, 1}), 10);
        assertEquals(1, rank);
    }

    @Test
    public void testRankWith01001() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(new Integer[]{3, 2}), 1001);
        assertEquals(3, rank);
    }

    @Test
    public void testRankWith11000() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(new Integer[]{3, 2}), 11000);
        assertEquals(9, rank);
    }

    @Test
    public void testRankWith10010() {
        Solution solution = new Solution();
        long rank = solution.rank(new Solution.FingerPrint(new Integer[]{3, 2}), 10010);
        assertEquals(7, rank);
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
