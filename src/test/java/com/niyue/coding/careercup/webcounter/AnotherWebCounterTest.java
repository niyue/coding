package com.niyue.coding.careercup.webcounter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class AnotherWebCounterTest {

	@Test
	public void testOneSecond() {
		AnotherWebCounter counter = new AnotherWebCounter();
		counter.increament();
		counter.increament();
		assertThat(counter.hitsInLastTwoSeconds(), is(2L));
		assertThat(counter.hitsInLastMinute(), is(2L));
		assertThat(counter.hitsInLastHour(), is(2L));
	}
	
	@Test
	public void testTwoSeconds() throws InterruptedException {
		AnotherWebCounter counter = new AnotherWebCounter();
		counter.increament();
		counter.increament();
		counter.increament();
		Thread.sleep(2000);
		counter.increament();
		counter.increament();
		assertThat(counter.hitsInLastTwoSeconds(), is(2L));
		assertThat(counter.hitsInLastMinute(), is(5L));
		assertThat(counter.hitsInLastHour(), is(5L));
	}
	
	@Test
	public void testOverflow() throws Exception {
		assertThat(Integer.MAX_VALUE + 1, is(Integer.MIN_VALUE));
		assertThat(Integer.MAX_VALUE + 1 - Integer.MAX_VALUE, is(1));
	}

}
