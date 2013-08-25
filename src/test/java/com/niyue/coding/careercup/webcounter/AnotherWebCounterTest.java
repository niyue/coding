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
		assertThat(counter.hitsInLastFiveSeconds(), is(2L));
		assertThat(counter.hitsInLastMinute(), is(2L));
		assertThat(counter.hitsInLastHour(), is(2L));
	}

}
