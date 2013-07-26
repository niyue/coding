package com.niyue.coding.misc.recentuniquechar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class RecentUniqueCharTest {

	@Test
	public void testAllUniqueChars() {
		RecentUniqueChar ruc = new RecentUniqueChar();
		ruc.add('a');
		assertThat(ruc.getMostRecent(), is('a'));
		ruc.add('b');
		assertThat(ruc.getMostRecent(), is('b'));
		ruc.add('c');
		assertThat(ruc.getMostRecent(), is('c'));
	}
	
	@Test
	public void testDuplicatedAtLast() {
		RecentUniqueChar ruc = new RecentUniqueChar();
		ruc.add('a');
		assertThat(ruc.getMostRecent(), is('a'));
		ruc.add('b');
		assertThat(ruc.getMostRecent(), is('b'));
		ruc.add('c');
		assertThat(ruc.getMostRecent(), is('c'));
		ruc.add('c');
		assertThat(ruc.getMostRecent(), is('b'));
	}
	
	@Test
	public void testDuplicatedInMiddle() {
		RecentUniqueChar ruc = new RecentUniqueChar();
		ruc.add('a');
		assertThat(ruc.getMostRecent(), is('a'));
		ruc.add('c');
		assertThat(ruc.getMostRecent(), is('c'));
		ruc.add('c');
		assertThat(ruc.getMostRecent(), is('a'));
		ruc.add('b');
		assertThat(ruc.getMostRecent(), is('b'));
	}
	
	@Test
	public void testDuplicatedInBetween() {
		RecentUniqueChar ruc = new RecentUniqueChar();
		ruc.add('a');
		assertThat(ruc.getMostRecent(), is('a'));
		ruc.add('c');
		assertThat(ruc.getMostRecent(), is('c'));
		ruc.add('b');
		assertThat(ruc.getMostRecent(), is('b'));
		ruc.add('c');
		assertThat(ruc.getMostRecent(), is('b'));
		ruc.add('b');
		assertThat(ruc.getMostRecent(), is('a'));
	}
}
