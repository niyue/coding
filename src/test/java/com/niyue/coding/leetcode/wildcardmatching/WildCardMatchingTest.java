package com.niyue.coding.leetcode.wildcardmatching;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WildCardMatchingTest {
	@Test
	public void testZeroLengthString() {
		Solution sl = new Solution();
		assertFalse(sl.isMatch("", "?"));
	}
	
	@Test
	// forget to reinitialize current variable in inner loop
	public void testDoubleA() {
		Solution sl = new Solution();
		assertTrue(sl.isMatch("aa", "aa"));
	}
	
	@Test
	public void testLongStringMatching() {
		Solution sl = new Solution();
		assertFalse(sl.isMatch("aaabbbbaaaabbabbbbaabbabaaababaababaaaaaaabaaababbaababbaababbbaaaaabaabbabbaabaababbaabababbbbbbbbabbaabbaaabaababaabaababababababbbbbbabbabbaabbaabaaaaaababaabbbaaabaaabbbbbbbbbaabaabaaabaaabbabbabb", "****a*b*b**b*bbb*b**bba***b**b*b*b**ba***b*b*a*b*b*****a**aaa*baaa*ba*****a****ba*a****a**b*******a*a"));
	}
}
