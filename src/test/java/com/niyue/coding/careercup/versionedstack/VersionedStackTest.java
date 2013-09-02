package com.niyue.coding.careercup.versionedstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class VersionedStackTest {
	@Test
	public void testPushAndPop() throws Exception {
		VersionedStack<Integer> stack = new VersionedStack<>();
		stack.push(1);
		assertThat(stack.pop(), is(1));
		assertThat(stack.version(1), is(Arrays.asList(1)));
		assertThat(stack.version(2), is(Collections.<Integer>emptyList()));
	}
	
	@Test
	public void testPushTwiceAndPop() throws Exception {
		VersionedStack<Integer> stack = new VersionedStack<>();
		stack.push(1);
		stack.push(2);
		assertThat(stack.pop(), is(2));
		assertThat(stack.pop(), is(1));
		assertThat(stack.getVersion(), is(4));
		assertThat(stack.version(1), is(Arrays.asList(1)));
		assertThat(stack.version(2), is(Arrays.asList(2, 1)));
		assertThat(stack.version(3), is(Arrays.asList(1)));
		assertThat(stack.version(4), is(Collections.<Integer>emptyList()));
	}
	
	@Test
	public void testMixedPushAndPop() throws Exception {
		VersionedStack<Integer> stack = new VersionedStack<>();
		stack.push(11);
		stack.push(8);
		assertThat(stack.pop(), is(8));
		stack.push(15);
		
		assertThat(stack.version(1), is(Arrays.asList(11)));
		assertThat(stack.version(2), is(Arrays.asList(8, 11)));
		assertThat(stack.version(3), is(Arrays.asList(11)));
		assertThat(stack.version(4), is(Arrays.asList(15, 11)));
	}
}
