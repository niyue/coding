package com.niyue.coding.misc.recentuniquechar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class RecentUniqueCharTest {

	@Test
	public void testAllUniqueChars() {
		RecentUniqueChar ruc = new RecentUniqueChar();
		char c = ruc.find('a', 'b', 'c');
		assertThat(c, is('c'));
	}
	
	@Test
	public void testDuplicatedAtLast() {
		RecentUniqueChar ruc = new RecentUniqueChar();
		char c = ruc.find('a', 'b', 'c', 'c');
		assertThat(c, is('b'));
	}
	
	@Test
	public void testDuplicatedInMiddle() {
		RecentUniqueChar ruc = new RecentUniqueChar();
		char c = ruc.find('a', 'c', 'c', 'b');
		assertThat(c, is('b'));
	}
	
	@Test
	public void testDuplicatedInBetween() {
		RecentUniqueChar ruc = new RecentUniqueChar();
		char c = ruc.find('a', 'c', 'b', 'c', 'b');
		assertThat(c, is('a'));
	}
}
