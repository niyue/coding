package com.niyue.coding.leetcode.wildcardmatching;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WildCardMatchingTwoTest {
	@Test
	public void testZeroLengthString() {
		SolutionTwo sl = new SolutionTwo();
		assertFalse(sl.isMatch("", "?"));
	}
	
	@Test
	public void testDoubleA() {
		SolutionTwo sl = new SolutionTwo();
		assertTrue(sl.isMatch("aa", "aa"));
	}
	
	@Test
	public void testLeadingAndTrailingWildcards() {
		SolutionTwo sl = new SolutionTwo();
		assertTrue(sl.isMatch("ababab", "*a**"));
	}
	
	@Test
	public void testLongStringMatching() {
		SolutionTwo sl = new SolutionTwo();
		assertFalse(sl.isMatch("aaabbbbaaaabbabbbbaabbabaaababaababaaaaaaabaaababbaababbaababbbaaaaabaabbabbaabaababbaabababbbbbbbbabbaabbaaabaababaabaababababababbbbbbabbabbaabbaabaaaaaababaabbbaaabaaabbbbbbbbbaabaabaaabaaabbabbabb", "****a*b*b**b*bbb*b**bba***b**b*b*b**ba***b*b*a*b*b*****a**aaa*baaa*ba*****a****ba*a****a**b*******a*a"));
	}
}
