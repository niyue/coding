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
    public void testAddMinimumNumber() {
        Solution solution = new Solution();
        List<Integer> min = solution.addMinimumNumber(new ArrayList(), Arrays.asList(1, 1, 1));
        assertThat(min, is(Arrays.asList(0, 1, 2)));
    }

    @Test
    public void testAddSimpleMinimumNumber() {
        Solution solution = new Solution();
        List<Integer> number = new ArrayList<Integer>();
        number.add(2);
        List<Integer> min = solution.addMinimumNumber(number, Arrays.asList(1, 1, 0));
        assertThat(min, is(Arrays.asList(2, 0, 1)));
    }

    @Test
    public void testNextGreaterNumberThreeDigits() {
        Solution solution = new Solution();
        List<Integer> nextGreaterNumber = solution.nextGreaterNumber(new Solution.FingerPrint(1, 1, 1), 199, 3);
        assertThat(nextGreaterNumber, is(Arrays.asList(2, 0, 1)));
    }

    @Test
    public void testNoNextGreaterNumber() {
        Solution solution = new Solution();
        List<Integer> nextGreaterNumber = solution.nextGreaterNumber(new Solution.FingerPrint(0, 1, 0), 105, 3);
        assertTrue(nextGreaterNumber.isEmpty());
    }

    @Test
    public void testNextGreaterNumberLastDigit() {
        Solution solution = new Solution();
        List<Integer> nextGreaterNumber = solution.nextGreaterNumber(new Solution.FingerPrint(1, 1, 1), 101, 3);
        assertThat(nextGreaterNumber, is(Arrays.asList(1, 0, 2)));
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
