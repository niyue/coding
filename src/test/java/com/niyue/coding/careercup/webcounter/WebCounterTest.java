package com.niyue.coding.careercup.webcounter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.junit.Test;

public class WebCounterTest {

	@Test
	public void testOneSecond() {
		WebCounter counter = new WebCounter();
		counter.hits(10);
		assertThat(counter.hitsInLastSecond(), is(10));
		assertThat(counter.hitsInLastMinute(), is(10));
	}
	
	@Test
	public void testTwoSeconds() {
		WebCounter counter = new WebCounter();
		counter.hits(10);
		assertThat(counter.hitsInLastSecond(), is(10));
		counter.hits(20);
		assertThat(counter.hitsInLastSecond(), is(20));
		assertThat(counter.hitsInLastMinute(), is(30));
	}
	
	@Test
	public void test61Seconds() {
		WebCounter counter = new WebCounter();
		for(int i = 0; i < 61; i++) {
			counter.hits(10);
			assertThat(counter.hitsInLastSecond(), is(10));
		}
		assertThat(counter.hitsInLastMinute(), is(600));
	}
	
	@Test
	public void test3601Seconds() {
		WebCounter counter = new WebCounter();
		for(int i = 0; i < 3601; i++) {
			counter.hits(10);
			assertThat(counter.hitsInLastSecond(), is(10));
		}
		assertThat(counter.hitsInLastMinute(), is(600));
	}
	
	@Test
	public void testRandomHits() {
		WebCounter counter = new WebCounter();
		for(int i = 0; i < 4000; i++) {
			counter.hits(10);
			assertThat(counter.hitsInLastSecond(), is(10));
		}
		assertThat(counter.hitsInLastMinute(), is(600));
		Random ran = new Random();
		int sum = 10 * 40;
		for(int i = 0; i < 20; i++) {
			int randomHits = ran.nextInt(100);
			counter.hits(randomHits);
			sum += randomHits;
		}
		assertThat(counter.hitsInLastMinute(), is(sum));
	}
}
