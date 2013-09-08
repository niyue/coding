package com.niyue.coding.careercup.perfectsquarenumber;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class PerfectSquareNumberTest {

	@Test
	public void testFindAll() {
		PerfectSquareNumber psn = new PerfectSquareNumber();
		List<Long> numbers = psn.find();
		assertThat(numbers.size() > 0, is(true));
//		for(long n : numbers) {
//			System.out.println(n);
//		}
	}

}
