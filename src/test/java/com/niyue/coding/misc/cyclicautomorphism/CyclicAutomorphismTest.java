package com.niyue.coding.misc.cyclicautomorphism;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class CyclicAutomorphismTest {

	@Test
	public void testByebye() {
		CyclicAutomorphism ca = new CyclicAutomorphism();
		int count = ca.count("byebye");
		assertThat(count, is(2));
	}
	
	@Test
	public void testBababa() {
		CyclicAutomorphism ca = new CyclicAutomorphism();
		int count = ca.count("bababa");
		assertThat(count, is(3));
	}
	
	@Test
	public void testAabbaabb() {
		CyclicAutomorphism ca = new CyclicAutomorphism();
		int count = ca.count("aabbaabb");
		assertThat(count, is(2));
	}

}
