package com.niyue.coding.misc.lrucache;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

import org.junit.Test;

public class LruCacheTest {

	@Test
	public void testSizeOneCache() {
		LruCache<String, Integer> cache = new LruCache<String, Integer>(1);
		cache.put("hello", 1);
		cache.put("world", 2);
		assertThat(cache.size(), is(1));
		assertThat(cache.get("world"), is(2));
	}
	
	@Test
	public void testSizeTwoCache() {
		LruCache<String, Integer> cache = new LruCache<String, Integer>(2);
		cache.put("hello", 1);
		cache.put("world", 2);
		assertThat(cache.size(), is(2));
		assertThat(cache.get("hello"), is(1));
		assertThat(cache.get("world"), is(2));
		
		cache.put("nihao", 3);
		assertThat(cache.size(), is(2));
		assertThat(cache.get("hello"), nullValue());
		assertThat(cache.get("world"), is(2));
		assertThat(cache.get("nihao"), is(3));
	}
	
	@Test
	public void testRecentlyAccess() {
		LruCache<String, Integer> cache = new LruCache<String, Integer>(2);
		cache.put("hello", 1);
		cache.put("world", 2);
		assertThat(cache.size(), is(2));
		assertThat(cache.get("hello"), is(1));
		
		cache.put("nihao", 3);
		assertThat(cache.size(), is(2));
		// hello is most recently access
		assertThat(cache.get("world"), nullValue());
		assertThat(cache.get("hello"), is(1));
		assertThat(cache.get("nihao"), is(3));
	}

}
